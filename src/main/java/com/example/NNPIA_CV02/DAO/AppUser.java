package com.example.NNPIA_CV02.DAO;

import jakarta.persistence.*;
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
