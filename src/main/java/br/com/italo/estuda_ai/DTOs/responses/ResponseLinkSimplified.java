package br.com.italo.estuda_ai.DTOs.responses;

import java.util.UUID;

public record ResponseLinkSimplified(
        UUID id,
        String title,
        String link
) {
}
