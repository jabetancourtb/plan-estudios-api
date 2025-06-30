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

	
	private Integer prerrequisitoCodigo;
	
    private Integer prerrequisitoSemestre;

    private String prerrequisito;

    
    private Integer asignaturaCodigo;
	
    private Integer asignaturaSemestre;

    private String asignatura;
	
}
