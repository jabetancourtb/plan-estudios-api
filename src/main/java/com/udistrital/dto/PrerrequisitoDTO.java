package com.udistrital.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class PrerrequisitoDTO {
	
	@NotNull
    @JsonProperty("id")
    private Integer id;

	@NotNull
    @JsonProperty("asignaturaAnteriorCodigo")
    private Integer asignaturaAnteriorCodigo;

	@NotNull
    @JsonProperty("asignaturaAnteriorSemestre")
    private Integer asignaturaAnteriorSemestre;

    @NotNull
    @JsonProperty("asignaturaAnteriorNombre")
    private String asignaturaAnteriorNombre;

    @NotNull
    @JsonProperty("asignaturaPosteriorCodigo")
    private Integer asignaturaPosteriorCodigo;

    @NotNull
    @JsonProperty("asignaturaPosteriorSemestre")
    private Integer asignaturaPosteriorSemestre;

    @NotNull
    @JsonProperty("asignaturaPosteriorNombre")
    private String asignaturaPosteriorNombre;
    
}
