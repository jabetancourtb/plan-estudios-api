package com.udistrital.service;

import org.springframework.data.domain.Page;

import com.udistrital.entity.Carrera;

public interface CarreraService {

	Page<Carrera> findCarrerasByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, boolean asc) throws Exception;
		
}
