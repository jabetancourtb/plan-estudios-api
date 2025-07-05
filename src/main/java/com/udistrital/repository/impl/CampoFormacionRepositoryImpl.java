package com.udistrital.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.udistrital.entity.CampoFormacion;
import com.udistrital.repository.CampoFormacionRepository;
import com.udistrital.repository.jpa.CampoFormacionJpaRepository;

@Repository
public class CampoFormacionRepositoryImpl implements CampoFormacionRepository {

	@Autowired
	public CampoFormacionJpaRepository campoFormacionJpaRepository;

	
	@Override
	public Page<CampoFormacion> findCamposFormacionWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return campoFormacionJpaRepository.findCamposFormacionWithPaginationAndSorting(PageRequest.of(page, pageSize, sorting));
	}
	
	
	@Override
	public CampoFormacion findCampoFormacionById(Integer id) throws Exception {
		return campoFormacionJpaRepository.findCampoFormacionById(id);
	}
	
	
	@Override
	public Page<CampoFormacion> findCamposFormacionByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return campoFormacionJpaRepository.findCamposFormacionByNameAndWithPaginationAndSorting(nombre, PageRequest.of(page, pageSize).withSort(sorting));
	}



	
}
