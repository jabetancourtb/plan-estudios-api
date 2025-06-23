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
    @JsonProperty("semestre_asignatura")
    private Integer semestreAsignatura;

    @NotNull
    @JsonProperty("codigo_condor")
    private Integer codigoCondor;

    @NotBlank
    @JsonProperty("campo_formacion")
    private String campoFormacion;

    @NotBlank
    @JsonProperty("area_formacion")
    private String areaFormacion;

    @NotBlank
    @JsonProperty("Espacio_Academico")
    private String espacioAcademico;

    @NotBlank
    @JsonProperty("Tipo")
    private String tipo;

    @NotBlank
    @JsonProperty("nombre")
    private String nombre;

    @NotNull
    @JsonProperty("numero_creditos")
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
    @JsonProperty("clasificacion_condor")
    private String clasificacionCondor;

    @NotNull
    @JsonProperty("clasificacion_espacio")
    private Integer clasificacionEspacio;

    @NotBlank
    @JsonProperty("Obligatorio_Basico")
    private String obligatorioBasico;

    @NotBlank
    @JsonProperty("Obligatorio_Complementario")
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
