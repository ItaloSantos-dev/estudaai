package br.com.italo.estuda_ai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.Duration;
import java.util.Set;
import java.util.UUID;

@Table(name = "submodules")
@Entity
public class SubmoduleModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "submodule", fetch = FetchType.LAZY)
    private Set<LinkModel> links;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "submodule", fetch = FetchType.LAZY)
    private Set<QuestionModel> questions;

    @Column(nullable = false)
    private Duration averageDuration;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleModel module;
}
