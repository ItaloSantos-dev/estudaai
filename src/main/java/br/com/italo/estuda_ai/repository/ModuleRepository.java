package br.com.italo.estuda_ai.repository;

import br.com.italo.estuda_ai.model.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID> {
}
