package com.example.busTicketBookingApplication.service.security;

import com.example.busTicketBookingApplication.entity.User;
import com.example.busTicketBookingApplication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        User user = userRepository.findByUserMail(userMail).orElseThrow(()->new UsernameNotFoundException(userMail));

        Set<GrantedAuthority> authorities =user.getRoles().stream()
                .map(role->new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserMail())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
