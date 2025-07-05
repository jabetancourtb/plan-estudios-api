package com.udistrital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.udistrital.entity.CampoFormacion;
import com.udistrital.repository.CampoFormacionRepository;
import com.udistrital.service.CampoFormacionService;


@Service
public class CampoFormacionServiceImpl implements CampoFormacionService {

	@Autowired
	public CampoFormacionRepository campoFormacionRepository;
	
	
	@Override
	public Page<CampoFormacion> findCamposFormacionWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		return campoFormacionRepository.findCamposFormacionWithPaginationAndSorting(page, pageSize, field, asc);
	}
	
	
	@Override
	public CampoFormacion findCampoFormacionById(Integer id) throws Exception {
		return campoFormacionRepository.findCampoFormacionById(id);
	}
	
	
	@Override
	public Page<CampoFormacion> findCamposFormacionByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		return campoFormacionRepository.findCamposFormacionByNameAndWithPaginationAndSorting(nombre, page, pageSize, field, asc);
	}
	
}
