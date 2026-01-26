package br.com.italo.estuda_ai.DTOs.responses.relations;

import br.com.italo.estuda_ai.DTOs.responses.ResponseSubmodulesSimplified;

import java.util.List;

public record ResponseSubmodulesOfModule(
        String CourseName,
        String moduleName,
        List<ResponseSubmodulesSimplified> submodules

) {
}
