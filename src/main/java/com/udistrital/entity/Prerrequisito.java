package com.udistrital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Prerrequisito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	private Integer asignaturaAnteriorCodigo;
	
    private Integer asignaturaAnteriorSemestre;

    private String asignaturaAnteriorNombre;

    
    private Integer asignaturaPosteriorCodigo;
	
    private Integer asignaturaPosteriorSemestre;

    private String asignaturaPosteriorNombre;
	
}
