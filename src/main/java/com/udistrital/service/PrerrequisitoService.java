package com.udistrital.service;

import org.springframework.data.domain.Page;

import com.udistrital.entity.Prerrequisito;

public interface PrerrequisitoService {

	Page<Prerrequisito> findAsignaturasPrerrequisitosWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	Page<Prerrequisito> findPrerrequisitosByCodigoPrerrequisitoWithPaginationAndSorting(Integer codigoPrerrequisito, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	Page<Prerrequisito> findPrerrequisitosByCodigoAsignaturaWithPaginationAndSorting(Integer codigoAsignatura, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
}
