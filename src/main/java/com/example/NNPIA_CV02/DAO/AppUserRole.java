package com.example.NNPIA_CV02.DAO;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "app_user_role")
@Data
public class AppUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "role_id")
    Role role;

    @ManyToOne
    @JoinColumn(nullable = false, name = "app_user_id")
    AppUser appUser;

}
