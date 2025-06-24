package com.udistrital.repository;

import org.springframework.data.domain.Page;

import com.udistrital.entity.Carrera;

public interface CarreraRepository {
	
	Page<Carrera> findCarrerasByNameAndWithPaginationAndSorting(String carrera, Integer page, Integer pageSize, boolean asc) throws Exception;
	
}
