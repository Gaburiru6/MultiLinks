package com.example.MultiLinks.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_url")
public class Url {
    @Column(nullable = false)
    private LocalDate dataExpiracao;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String urlEncurtada;

    @Column(nullable = false)
    private String urlOriginal;
}




