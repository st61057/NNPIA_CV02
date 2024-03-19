package com.example.NNPIA_CV02.controller;


import com.example.NNPIA_CV02.DAO.AppUser;
import com.example.NNPIA_CV02.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping(value = "/app-user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUser> getAppUser(@PathVariable("id") int id) {
        AppUser user = repository.findAppUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/app-user-add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewUser(@RequestBody AppUser appUser) {
        if (appUser != null) {
            repository.save(appUser);
            return ResponseEntity.ok().body("Sucessfully added new user");
        }
        if (repository.findAppUserById(appUser.getId()) != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        return ResponseEntity.badRequest().body("Problem somewhere in passed user");
    }

    @PutMapping(value = "/app-user-update")
    public ResponseEntity<?> updateExistingUser(@RequestParam int id, @RequestBody AppUser appUser) {
        AppUser currentUser = repository.findAppUserById(id);
        currentUser.setUsername(appUser.getUsername());
        currentUser.setAppUserRoles(appUser.getAppUserRoles());
        currentUser.setCreationDate(appUser.getCreationDate());
        currentUser.setUpdateDate(appUser.getUpdateDate());
        currentUser.setActive(appUser.isActive());
        currentUser.setPassword(appUser.getPassword());
        repository.save(currentUser);
        return ResponseEntity.ok().body("User updated");
    }

    @PreAuthorize("i")
    @DeleteMapping(value = "/app-user-delete/{id}")
    public ResponseEntity<?> deleteExistingUser(@PathVariable("id") int id) {
        AppUser appUser = repository.findAppUserById(id);
        if (appUser != null) {
            repository.delete(appUser);
            return ResponseEntity.ok().body("Successfully deleted");
        }
        return ResponseEntity.notFound().build();
    }


}
