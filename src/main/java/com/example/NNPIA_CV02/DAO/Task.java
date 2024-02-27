package com.example.NNPIA_CV02.DAO;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String description;

    @Column(nullable = false, name = "creation_date")
    Date creationDate;

    @Column(nullable = false, name = "update_date")
    Date updateDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "author_id")
    AppUser authorId;

}
