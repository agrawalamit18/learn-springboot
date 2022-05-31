package com.learn.springboot.learnspringboot.service;

import com.learn.springboot.learnspringboot.entity.Registration;
import com.learn.springboot.learnspringboot.model.RegistrationModel;
import com.learn.springboot.learnspringboot.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    public RegistrationRepository repository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public Registration save (RegistrationModel registration) {
        Registration registrationEn = Registration.builder().userId(registration.getUserId())
                .userName(registration.getUserName())
                .password(passwordEncoder.encode(registration.getPassword())).build();
        registrationEn = repository.save(registrationEn);
        return registrationEn;
    }
}