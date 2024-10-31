package com.secure.notes.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 100)
    private String description;
    @Lob
    private String content;
    @Column(length = 100)
    private String ownerUserName;


}
