package com.example.NNPIA_CV02.service;

import com.example.NNPIA_CV02.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RequestMapping("/dev")
public interface IService {

    @GetMapping("/")
    HashMap<Integer, User> getAllUsers();

    @GetMapping("/{id}")
    Optional<User> getUserById(@PathVariable Integer id);


}
