package br.com.italo.estuda_ai.DTOs.responses.relations;


import br.com.italo.estuda_ai.DTOs.responses.ResponseModuleSimplified;

import java.util.List;


public record ResponseModulesOfCourse(
        String courseName,
        List<ResponseModuleSimplified> modules
) {

}
