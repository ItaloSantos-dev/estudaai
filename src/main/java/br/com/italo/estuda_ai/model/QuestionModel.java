package br.com.italo.estuda_ai.model;

import br.com.italo.estuda_ai.model.enums.QuestionType;
import jakarta.persistence.*;

import java.time.Duration;
import java.util.Set;
import java.util.UUID;
@Table(name = "questions")
@Entity
public class QuestionModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    QuestionType type;

    @Column(nullable = false)
    private String link;

    @ManyToOne
    @JoinColumn(name = "submodule_id")
    private SubmoduleModel submodule;


}
