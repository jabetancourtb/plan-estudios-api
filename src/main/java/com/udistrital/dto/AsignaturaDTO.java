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
public class AsignaturaDTO {
	
	@NotNull
    @JsonProperty("codigo")
    private Integer codigo;

    @NotBlank
    @JsonProperty("carrera")
    private String carrera;

    @NotNull
    @JsonProperty("semestreAsignatura")
    private Integer semestreAsignatura;

    @NotNull
    @JsonProperty("codigoCondor")
    private Integer codigoCondor;

    @NotBlank
    @JsonProperty("campoFormacion")
    private String campoFormacion;

    @NotBlank
    @JsonProperty("areaFormacion")
    private String areaFormacion;

    @NotBlank
    @JsonProperty("EspacioAcademico")
    private String espacioAcademico;

    @NotBlank
    @JsonProperty("Tipo")
    private String tipo;

    @NotBlank
    @JsonProperty("nombre")
    private String nombre;

    @NotNull
    @JsonProperty("numeroCreditos")
    private Integer numeroCreditos;

    @NotNull
    @JsonProperty("HTD")
    private Integer htd;

    @NotNull
    @JsonProperty("HTC")
    private Integer htc;

    @NotNull
    @JsonProperty("HTA")
    private Integer hta;

    @NotBlank
    @JsonProperty("clasificacionCondor")
    private String clasificacionCondor;

    @NotNull
    @JsonProperty("clasificacionEspacio")
    private Integer clasificacionEspacio;

    @NotBlank
    @JsonProperty("ObligatorioBasico")
    private String obligatorioBasico;

    @NotBlank
    @JsonProperty("ObligatorioComplementario")
    private String obligatorioComplementario;

    @NotBlank
    @JsonProperty("ElectivoIntrinseco")
    private String electivoIntrinseco;

    @NotBlank
    @JsonProperty("ElectivoExtrinseco")
    private String electivoExtrinseco;

    @JsonProperty("justificacion")
    private String justificacion;
	
}
