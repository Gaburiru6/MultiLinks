package com.example.MultiLinks.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;
}
