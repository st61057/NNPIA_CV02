package com.example.NNPIA_CV02.repository;

import com.example.NNPIA_CV02.DAO.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Repository extends JpaRepository<AppUser, Integer> {
    @Override
    @Query("SELECT user FROM AppUser user WHERE user.active = true")
    public List<AppUser> findAll();

    @Query("SELECT user FROM AppUser user JOIN user.appUserRoles aur JOIN aur.role r WHERE r.name = :nameOfRole")
    public List<AppUser> findAllByRole(@Param("nameOfRole") String name);

}
