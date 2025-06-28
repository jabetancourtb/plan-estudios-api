package com.udistrital.service;

import org.springframework.data.domain.Page;

import com.udistrital.entity.AreaFormacion;


public interface AreaFormacionService {
	
	Page<AreaFormacion> findAreasFormacionWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;

	Page<AreaFormacion> findAreasFormacionByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc) throws Exception;

}
