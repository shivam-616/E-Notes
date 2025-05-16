package com.example.Notes_App.servies;

import com.example.Notes_App.DTO.UserRegistrationDto;
import com.example.Notes_App.Respository.UserRepository;
import com.example.Notes_App.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public void registerNewUser(UserRegistrationDto dto) {


        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }

}
