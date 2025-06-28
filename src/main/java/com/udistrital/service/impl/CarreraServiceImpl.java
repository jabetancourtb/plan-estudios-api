package com.udistrital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.udistrital.entity.Carrera;
import com.udistrital.repository.CarreraRepository;
import com.udistrital.service.CarreraService;


@Service
public class CarreraServiceImpl implements CarreraService {

	@Autowired
	public CarreraRepository carreraRepository;
	
	
	@Override
	public Page<Carrera> findCarrerasWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		return carreraRepository.findCarrerasWithPaginationAndSorting(page, pageSize, field, asc);
	}
	
	
	@Override
	public Page<Carrera> findCarrerasByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		return carreraRepository.findCarrerasByNameAndWithPaginationAndSorting(nombre, page, pageSize, field, asc);
	}

}
