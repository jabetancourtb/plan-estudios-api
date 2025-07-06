package com.udistrital.service;

import org.springframework.data.domain.Page;

import com.udistrital.entity.AreaFormacion;


public interface AreaFormacionService {
	
	Page<AreaFormacion> findAreasFormacionWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	AreaFormacion findAreaFormacionById(Integer id) throws Exception;

	Page<AreaFormacion> findAreasFormacionByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	Page<AreaFormacion> findAreasFormacionByIdCampoFormacionAndWithPaginationAndSorting(Integer idCampoFormacion, Integer page, Integer pageSize, String field, boolean asc) throws Exception;

	Page<AreaFormacion> findAreasFormacionByNombreCampoFormacionAndWithPaginationAndSorting(String nombreCampoFormacion, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
}
