package com.udistrital.repository;

import org.springframework.data.domain.Page;

import com.udistrital.entity.CampoFormacion;


public interface CampoFormacionRepository {
	
	Page<CampoFormacion> findCamposFormacionWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;

	Page<CampoFormacion> findCamposFormacionByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
}
