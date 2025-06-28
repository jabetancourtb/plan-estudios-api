package com.udistrital.repository;

import org.springframework.data.domain.Page;

import com.udistrital.entity.Carrera;

public interface CarreraRepository {
	
	Page<Carrera> findCarrerasWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
	Page<Carrera> findCarrerasByNameAndWithPaginationAndSorting(String carrera, Integer page, Integer pageSize, String field, boolean asc) throws Exception;
	
}
