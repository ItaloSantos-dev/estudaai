package br.com.italo.estuda_ai.DTOs.responses.relations;

import br.com.italo.estuda_ai.DTOs.responses.ResponseLinkSimplified;

import java.util.List;

public record ResponseLinksOfSubmodule(
        String courseName,
        String moduleName,
        String submoduleName,
        List<ResponseLinkSimplified> links

) {
}
