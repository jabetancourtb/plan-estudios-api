package com.udistrital.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "res_asignatura")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Asignatura implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer codigo;
	
	@Column(name = "carrera", nullable = false, length = 60)
    private String carrera;

    @Column(name = "semestre_asignatura", nullable = false)
    private Integer semestreAsignatura;

    @Column(name = "codigo_condor", nullable = false)
    private Integer codigoCondor;

    @Column(name = "campo_formacion", nullable = false, length = 30)
    private String campoFormacion;

    @Column(name = "area_formacion", nullable = false, length = 45)
    private String areaFormacion;

    @Column(name = "Espacio_Academico", nullable = false, length = 40)
    private String espacioAcademico;

    @Column(name = "Tipo", nullable = false, length = 40)
    private String tipo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "numero_creditos", nullable = false)
    private Integer numeroCreditos;

    @Column(name = "HTD", nullable = false)
    private Integer htd;

    @Column(name = "HTC", nullable = false)
    private Integer htc;

    @Column(name = "HTA", nullable = false)
    private Integer hta;

    @Column(name = "clasificacion_condor", nullable = false, length = 30)
    private String clasificacionCondor;

    @Column(name = "clasificacion_espacio", nullable = false)
    private Integer clasificacionEspacio;

    @Column(name = "Obligatorio_Basico", nullable = false, length = 7)
    private String obligatorioBasico;

    @Column(name = "Obligatorio_Complementario", nullable = false, length = 7)
    private String obligatorioComplementario;

    @Column(name = "ElectivoIntrinseco", nullable = false, length = 7)
    private String electivoIntrinseco;

    @Column(name = "ElectivoExtrinseco", nullable = false, length = 7)
    private String electivoExtrinseco;

    @Column(name = "justificacion", length = 5000)
    private String justificacion;
	
}
