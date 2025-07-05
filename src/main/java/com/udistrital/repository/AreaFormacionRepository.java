package com.udistrital.repository;

import org.springframework.data.domain.Page;

import com.udistrital.entity.AreaFormacion;


public interface AreaFormacionRepository {
	
	Page<AreaFormacion> findAreasFormacionWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	AreaFormacion findAreaFormacionById(Integer id) throws Exception;

	Page<AreaFormacion> findAreasFormacionByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	Page<AreaFormacion> findAreasFormacionByIdCampoFormacionAndWithPaginationAndSorting(Integer idCampoFormacion, Integer page, Integer pageSize, String field, boolean asc) throws Exception;

}
