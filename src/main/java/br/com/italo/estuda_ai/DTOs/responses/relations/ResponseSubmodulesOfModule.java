package br.com.italo.estuda_ai.DTOs.responses.relations;

import br.com.italo.estuda_ai.DTOs.responses.ResponseSubmoduleSimplified;

import java.util.List;

public record ResponseSubmodulesOfModule(
        String CourseName,
        String moduleName,
        List<ResponseSubmoduleSimplified> submodules

) {
}
