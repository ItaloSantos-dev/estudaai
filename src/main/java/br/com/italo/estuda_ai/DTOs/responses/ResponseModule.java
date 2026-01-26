package br.com.italo.estuda_ai.DTOs.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Duration;
import java.util.UUID;

@JsonIgnoreProperties
public record ResponseModule (
        UUID id,
        String name,
        Duration averageDuration,
        String course
){

}
