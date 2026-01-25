package br.com.italo.estuda_ai.repository;

import br.com.italo.estuda_ai.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseModel, UUID> {
}
