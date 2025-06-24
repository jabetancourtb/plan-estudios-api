package com.udistrital.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CarreraDTO {

	@NotBlank
    @JsonProperty("carrera")
    private String carrera;
	
}
