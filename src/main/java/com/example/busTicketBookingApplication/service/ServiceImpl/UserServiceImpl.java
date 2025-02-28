package com.example.busTicketBookingApplication.service.ServiceImpl;

import com.example.busTicketBookingApplication.dto.UserDto;
import com.example.busTicketBookingApplication.entity.Role;
import com.example.busTicketBookingApplication.entity.User;
import com.example.busTicketBookingApplication.exception.UserAlreadyExistsException;
import com.example.busTicketBookingApplication.repository.RoleRepository;
import com.example.busTicketBookingApplication.repository.UserRepository;
import com.example.busTicketBookingApplication.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByUserMail(userDto.getUserMail());
        if(optionalUser.isPresent()){
            throw new UserAlreadyExistsException(userDto.getUserMail());
        }
        else {

            // Set the role(s) for the user

            User newUser = modelMapper.map(userDto,User.class);
            newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
            Optional<Role> userRole =  roleRepository.findById(1l);
            Set<Role> roles = new HashSet<>();
            roles.add(userRole.get());  // Only adding one role for now (can add more if needed)
            newUser.setRoles(roles);
            User savedUser = userRepository.save(newUser);
            /// /Yet to encrypt the password
            return modelMapper.map(savedUser,UserDto.class);
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> userList = userRepository.findAll();
       List<UserDto> userDtoList = userList.stream().map(i-> modelMapper.map(i,UserDto.class)).collect(Collectors.toList());
       return userDtoList;
     }

    @Override
    public UserDto findUserByMailId(String userMail) {
        Optional<User> optionalUser = userRepository.findByUserMail(userMail);
        return  modelMapper.map(optionalUser.get(),UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }
}
