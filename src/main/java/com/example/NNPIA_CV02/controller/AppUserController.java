package com.example.NNPIA_CV02.controller;


import com.example.NNPIA_CV02.DAO.AppUser;
import com.example.NNPIA_CV02.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppUserController {

    @Autowired
    public Repository repository;

    @GetMapping("/getallappusers")
    public List<AppUser> getAllAppUsers(Model model) {
        List<AppUser> users = repository.findAll();
        model.addAttribute("users", users);
        return users;
    }

    @GetMapping(name = "/getallappuserbyrole/{roleName}")
    public List<AppUser> getAllAppUsersByRoleName(@PathVariable("roleName") String roleName) {
        List<AppUser> users = repository.findAllByRole(roleName);
        return users;
    }


}
