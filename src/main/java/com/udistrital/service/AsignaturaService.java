package com.udistrital.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.udistrital.entity.Asignatura;

public interface AsignaturaService {
	
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
	Page<Asignatura> findAsignaturasByAreaFormacionWithPaginationAndSorting(String areaFormacion, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
		
	// ASIGNATURAS POR CAMPO DE FORMACIÓN Y ÁREA DE FORMACIÓN
	Page<Asignatura> findAsignaturasByAreaFormacionAndCampoFormacionWithPaginationAndSorting(String campoFormacion, String areaFormacion, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	// ASIGNATURAS POR SEMESTRE
	Page<Asignatura> findAsignaturasBySemestreAndWithPaginationAndSorting(Integer semestre, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	
	
	// SEMESTRES
	Page<Integer> findSemestresWithPaginationAndSorting(boolean asc) throws Exception;
	
}
