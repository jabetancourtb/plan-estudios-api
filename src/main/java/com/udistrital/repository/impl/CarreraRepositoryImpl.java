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
	public Page<Carrera> findCarrerasWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return carreraJpaRepository.findAll(PageRequest.of(page, pageSize).withSort(sorting));
	}

	
	@Override
	public Page<Carrera> findCarrerasByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return carreraJpaRepository.findCarrerasByNameAndWithPaginationAndSorting(nombre, PageRequest.of(page, pageSize).withSort(sorting));
	}
		
}
