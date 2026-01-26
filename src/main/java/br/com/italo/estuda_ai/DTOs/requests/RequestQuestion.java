package br.com.italo.estuda_ai.DTOs.requests;

import br.com.italo.estuda_ai.model.enums.QuestionType;

import java.util.UUID;

public record RequestQuestion(
        String title,
        String link,
        QuestionType type,
        String submodule_id
) {
}
