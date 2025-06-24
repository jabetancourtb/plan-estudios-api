package com.udistrital.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.udistrital.entity.Carrera;
import com.udistrital.repository.CarreraRepository;
import com.udistrital.repository.jpa.CarreraJpaRepository;


@Repository
public class CarreraRepositoryImpl implements CarreraRepository {
	
	@Autowired
	public CarreraJpaRepository carreraJpaRepository;

	
	@Override
	public Page<Carrera> findCarrerasByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, boolean asc)
			throws Exception {
		Sort sorting = Sort.by("carrera");
		
		if(!asc) {
			sorting = Sort.by("carrera").descending();
		}

		return carreraJpaRepository.findCarreraByNameAndWithPaginationAndSorting(nombre, PageRequest.of(page, pageSize).withSort(sorting));
	}
		
}
