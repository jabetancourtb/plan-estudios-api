package com.udistrital.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.udistrital.entity.Prerrequisito;
import com.udistrital.repository.PrerrequisitoRepository;
import com.udistrital.repository.jpa.PrerrequisitoJpaRepository;


@Repository
public class PrerrequisitoRepositoryImpl implements PrerrequisitoRepository {
	
	@Autowired
	private PrerrequisitoJpaRepository prerrequisitoJpaRepository;

	
	@Override
	public Page<Prerrequisito> findAsignaturasPrerrequisitosWithPaginationAndSorting(Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return prerrequisitoJpaRepository.findAsignaturasPrerrequisitosWithPaginationAndSorting(PageRequest.of(page, pageSize).withSort(sorting));
	}

	
	@Override
	public Page<Prerrequisito> findPrerrequisitosByCodigoPrerrequisitoWithPaginationAndSorting(
			Integer codigoPrerrequisito, Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return prerrequisitoJpaRepository.findPrerrequisitosByCodigoPrerrequisitoWithPaginationAndSorting(codigoPrerrequisito, PageRequest.of(page, pageSize).withSort(sorting));
	}

	
	@Override
	public Page<Prerrequisito> findPrerrequisitosByCodigoAsignaturaWithPaginationAndSorting(Integer codigoAsignatura, Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return prerrequisitoJpaRepository.findPrerrequisitosByCodigoAsignaturaWithPaginationAndSorting(codigoAsignatura, PageRequest.of(page, pageSize).withSort(sorting));
	}

}
