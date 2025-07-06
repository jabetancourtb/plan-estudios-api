package com.udistrital.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.udistrital.entity.AreaFormacion;
import com.udistrital.repository.AreaFormacionRepository;
import com.udistrital.repository.jpa.AreaFormacionJpaRepository;


@Repository
public class AreaFormacionRepositoryImpl implements AreaFormacionRepository {

	@Autowired
	public AreaFormacionJpaRepository areaFormacionJpaRepository;
	
	
	@Override
	public Page<AreaFormacion> findAreasFormacionWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return areaFormacionJpaRepository.findAreasFormacionWithPaginationAndSorting(PageRequest.of(page, pageSize).withSort(sorting));
	}
	
	
	@Override
	public AreaFormacion findAreaFormacionById(Integer id) throws Exception {
		return areaFormacionJpaRepository.findAreaFormacionById(id);
	}

	
	@Override
	public Page<AreaFormacion> findAreasFormacionByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return areaFormacionJpaRepository.findAreasFormacionByNameAndWithPaginationAndSorting(nombre, PageRequest.of(page, pageSize).withSort(sorting));
	}


	@Override
	public Page<AreaFormacion> findAreasFormacionByIdCampoFormacionAndWithPaginationAndSorting(Integer idCampoFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return areaFormacionJpaRepository.findAreasFormacionByIdCampoFormacionAndWithPaginationAndSorting(idCampoFormacion, PageRequest.of(page, pageSize).withSort(sorting));
	}
	
	
	@Override
	public Page<AreaFormacion> findAreasFormacionByNombreCampoFormacionAndWithPaginationAndSorting(String nombreCampoFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return areaFormacionJpaRepository.findAreasFormacionByNombreCampoFormacionAndWithPaginationAndSorting(nombreCampoFormacion, PageRequest.of(page, pageSize).withSort(sorting));
	}

	
}
