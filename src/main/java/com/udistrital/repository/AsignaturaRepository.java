package com.udistrital.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.udistrital.entity.Asignatura;

public interface AsignaturaRepository {
	
	Asignatura saveAsignatura(Asignatura asignatura) throws Exception;
	
	List<Asignatura> saveAsignaturas(List<Asignatura> asignaturas) throws Exception;
	
	void deleteAsignaturaByCodigo(Integer codigoAsignatura) throws Exception;
	
	Asignatura findAsignaturaByCodigo(Integer codigoAsignatura) throws Exception;
	
	Page<Asignatura> findAsignaturasWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	
	// ASIGNATURAS POR CARRERA
	Page<Asignatura> findAsignaturasByCarreraAndWithPaginationAndSorting(String carrera, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	// ASIGNATURAS POR CAMPO DE FORMACIÓN
	Page<Asignatura> findAsignaturasByCampoFormacionAndWithPaginationAndSorting(String campoFormacion, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	// ASIGNATURAS POR ÁREA DE FORMACIÓN
	Page<Asignatura> findAsignaturasByAreaFormacionAndWithPaginationAndSorting(String areaFormacion, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	// ASIGNATURAS POR SEMESTRE
	Page<Asignatura> findAsignaturasBySemestreAndWithPaginationAndSorting(Integer semestre, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	
	
	// CAMPOS DE FORMACIÓN
	Page<Asignatura> findCamposFormacionAndWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	// ÁREAS DE FORMACIÓN
	Page<Asignatura> findAreasFormacionAndWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	// SEMESTRES
	Page<Asignatura> findSemestresAndWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
}
