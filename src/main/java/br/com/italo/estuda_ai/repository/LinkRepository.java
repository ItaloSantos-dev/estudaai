package br.com.italo.estuda_ai.repository;

import br.com.italo.estuda_ai.model.LinkModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LinkRepository extends JpaRepository<LinkModel, UUID> {
}
