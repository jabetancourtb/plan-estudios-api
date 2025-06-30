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
    @JsonProperty("prerrequisitoCodigo")
    private Integer prerrequisitoCodigo;

	@NotNull
    @JsonProperty("prerrequisitoSemestre")
    private Integer prerrequisitoSemestre;

    @NotNull
    @JsonProperty("prerrequisito")
    private String prerrequisito;

    @NotNull
    @JsonProperty("asignaturaCodigo")
    private Integer asignaturaCodigo;

    @NotNull
    @JsonProperty("asignaturaSemestre")
    private Integer asignaturaSemestre;

    @NotNull
    @JsonProperty("asignatura")
    private String asignatura;
    
}
