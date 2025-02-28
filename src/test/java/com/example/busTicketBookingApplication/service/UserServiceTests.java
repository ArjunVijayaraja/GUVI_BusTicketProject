package com.example.busTicketBookingApplication.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.busTicketBookingApplication.dto.UserDto;
import com.example.busTicketBookingApplication.entity.Role;
import com.example.busTicketBookingApplication.entity.User;
import com.example.busTicketBookingApplication.exception.UserAlreadyExistsException;
import com.example.busTicketBookingApplication.repository.RoleRepository;
import com.example.busTicketBookingApplication.repository.UserRepository;
import com.example.busTicketBookingApplication.service.ServiceImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@ExtendWith(MockitoExtension.class)

public class UserServiceTests {
    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private UserDto userDto;
    private User user;
    private Role role;

    @BeforeEach
    void setUp() {
        userDto = new UserDto(1L, "Arjun", "arjun@gmail.com", "test123", "1234567890");
        user = new User();

        user.setUserId(1L);
        user.setUserName("Arjun");
        user.setUserMail("arjun@gmail.com");
        user.setPassword("encodedPassword");

        role = new Role(1L, "ROLE_USER");
    }

    @Test
    void testCreateUser_Success() {
        when(userRepository.findByUserMail(userDto.getUserMail())).thenReturn(Optional.empty());
        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));
        when(passwordEncoder.encode(userDto.getPassword())).thenReturn("encodedPassword");
        when(modelMapper.map(userDto, User.class)).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(modelMapper.map(user, UserDto.class)).thenReturn(userDto);

        UserDto savedUser = userService.createUser(userDto);

        assertNotNull(savedUser);
        assertEquals(userDto.getUserMail(), savedUser.getUserMail());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testCreateUser_UserAlreadyExists() {
        when(userRepository.findByUserMail(userDto.getUserMail())).thenReturn(Optional.of(user));

        assertThrows(UserAlreadyExistsException.class, () -> userService.createUser(userDto));
        verify(userRepository, never()).save(any(User.class));
    }
}
