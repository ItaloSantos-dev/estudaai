package br.com.italo.estuda_ai.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.util.Set;
import java.util.UUID;
@Table(name = "links")
@Entity
public class LinkModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String link;

    @ManyToOne
    @JoinColumn(name = "submodule_id")
    private SubmoduleModel submodule;

}
