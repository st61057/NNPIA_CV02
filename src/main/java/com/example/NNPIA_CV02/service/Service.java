package com.example.NNPIA_CV02.service;

import com.example.NNPIA_CV02.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class Service implements IService {

    public HashMap<Integer, User> listOfUsers = new HashMap<>();

    public Service() {
        for (int i = 0; i < 3; i++) listOfUsers.put(i, new User(i, "username" + i, "fullname" + i));
    }

    @Override
    public HashMap<Integer, User> getAllUsers() {
        return listOfUsers;
    }
    @Override
    public Optional<User> getUserById(Integer id) {
        return Optional.ofNullable(listOfUsers.get(id));
    }
}
