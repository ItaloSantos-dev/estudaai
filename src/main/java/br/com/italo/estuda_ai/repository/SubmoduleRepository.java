package br.com.italo.estuda_ai.repository;

import br.com.italo.estuda_ai.model.SubmoduleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubmoduleRepository extends JpaRepository<SubmoduleModel, UUID> {
}
