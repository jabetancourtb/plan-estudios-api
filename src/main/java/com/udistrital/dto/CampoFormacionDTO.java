package com.udistrital.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CampoFormacionDTO {

	@NotNull
    @JsonProperty("id")
    private Integer id;
	
	@NotBlank
    @JsonProperty("nombre")
    private String nombre;
	
}
