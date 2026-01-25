package br.com.italo.estuda_ai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Table(name = "modules")
@Entity
public class ModuleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Duration averageDuration;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseModel course;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "module")
    private Set<SubmoduleModel> submodules = new HashSet<>();
}
