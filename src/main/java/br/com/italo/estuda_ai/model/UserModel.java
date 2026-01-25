package br.com.italo.estuda_ai.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "users")
@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate nasciment;

    @ManyToMany
    @JoinTable(
            name = "course_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<CourseModel> courses = new HashSet<>();


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getNasciment() {
        return nasciment;
    }

    public void setNasciment(LocalDate nasciment) {
        this.nasciment = nasciment;
    }

    public Set<CourseModel> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseModel> courses) {
        this.courses = courses;
    }
}
