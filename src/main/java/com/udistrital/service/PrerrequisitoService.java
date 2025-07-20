package com.udistrital.service;

import org.springframework.data.domain.Page;

import com.udistrital.entity.Prerrequisito;

public interface PrerrequisitoService {

	Page<Prerrequisito> findPrerrequisitosWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	Page<Prerrequisito> findAsignaturasAnterioresByCodigoAsignaturaWithPaginationAndSorting(Integer codigo, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	Page<Prerrequisito> findAsignaturasPosterioresByCodigoAsignaturaWithPaginationAndSorting(Integer codigo, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
}
