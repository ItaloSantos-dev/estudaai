package br.com.italo.estuda_ai.DTOs.responses.relations;

import br.com.italo.estuda_ai.DTOs.responses.ResponseQuestionSimplified;

import java.util.List;

public record ResponseQuestionsOfSubmodule(
        String courseName,
        String moduleName,
        String submoduleName,
        List<ResponseQuestionSimplified> questions
) {
}
