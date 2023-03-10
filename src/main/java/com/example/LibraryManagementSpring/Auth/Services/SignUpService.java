package com.example.LibraryManagementSpring.Auth.Services;

import com.example.LibraryManagementSpring.Users.Entities.CustomUser;
import com.example.LibraryManagementSpring.Users.Repositories.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpService {
    @Autowired
    CustomUserRepository customUserRepository;

    public CustomUser signUpUser(CustomUser user){
        System.out.println(user.toString());
        Optional<CustomUser> userExist = customUserRepository.findCustomUserByUsername(user.getUsername());
        return userExist.orElseGet(() -> customUserRepository.save(user));
    }
}
