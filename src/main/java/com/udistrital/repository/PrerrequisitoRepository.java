package com.udistrital.repository;

import org.springframework.data.domain.Page;

import com.udistrital.entity.Prerrequisito;

public interface PrerrequisitoRepository {

	Page<Prerrequisito> findAsignaturasPrerrequisitosWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	Page<Prerrequisito> findAsignaturasPosterioresByCodigoPrerrequisitoWithPaginationAndSorting(Integer codigoPrerrequisito, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	Page<Prerrequisito> findAsignaturasPrerrequisitosByCodigoAsignaturaWithPaginationAndSorting(Integer codigoAsignatura, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
}
