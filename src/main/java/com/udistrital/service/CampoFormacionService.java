package com.udistrital.service;

import org.springframework.data.domain.Page;

import com.udistrital.entity.CampoFormacion;


public interface CampoFormacionService {
	
	Page<CampoFormacion> findCamposFormacionWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	Page<CampoFormacion> findCamposFormacionByIdAndWithPaginationAndSorting(Integer id, Integer page, Integer pageSize, String field, boolean asc) throws Exception;

	Page<CampoFormacion> findCamposFormacionByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
}
