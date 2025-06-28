package com.udistrital.service;

import org.springframework.data.domain.Page;

import com.udistrital.entity.Carrera;

public interface CarreraService {
	
	Page<Carrera> findCarrerasWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;

	Page<Carrera> findCarrerasByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
		
}
