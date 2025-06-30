package com.udistrital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "area_formacion")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class AreaFormacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nombre", nullable = false, length = 60)
    private String nombre;
	
	@Column(name = "color_html", nullable = true, length = 60)
    private String colorHtml;
	
	@Column(name = "cantidad_asignaturas", nullable = true)
    private Integer cantidadAsignaturas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_campo_formacion")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonProperty(access = Access.WRITE_ONLY)
	private CampoFormacion campoFormacion;
	
}
