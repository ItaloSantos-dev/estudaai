package br.com.italo.estuda_ai.repository;

import br.com.italo.estuda_ai.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<QuestionModel, UUID> {
}
