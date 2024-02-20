package com.example.NNPIA_CV02.controller;

import com.example.NNPIA_CV02.model.User;
import com.example.NNPIA_CV02.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
//@RequestMapping("/user")
public class ServiceController {
    public Service service;

    public ServiceController() {
        service = new Service();
    }

    @GetMapping(value = "getuser/{id}")
    public String getUser(@PathVariable("id") Integer id){
        return service.getUserById(id).toString();
    }

    @GetMapping("/getallusers")
    public String getAllUsers() {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Integer, User> user : service.getAllUsers().entrySet()) {
            sb.append(user.getValue() + ", ");
        }
        return sb.toString();
    }


}
