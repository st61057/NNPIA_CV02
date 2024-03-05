package com.example.NNPIA_CV02.DAO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.Set;


//
@Entity
@Table(name = "app_user")
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(nullable = false)
    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be empty")
    @Size(max = 255)
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    boolean active;

    @Column(nullable = false, name = "creation_date")
    Date creationDate;

    @Column(nullable = false, name = "update_date")
    Date updateDate;

    @OneToMany(mappedBy = "appUser")
    Set<AppUserRole> appUserRoles;

}
