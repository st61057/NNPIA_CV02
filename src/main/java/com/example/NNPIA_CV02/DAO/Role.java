package com.example.NNPIA_CV02.DAO;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(nullable = false)
    String name;

    @OneToMany(mappedBy = "role")
    Set<AppUserRole> appUserRoles;

}
