package com.udistrital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.udistrital.entity.AreaFormacion;
import com.udistrital.repository.AreaFormacionRepository;
import com.udistrital.service.AreaFormacionService;


@Service
public class AreaFormacionServiceImpl implements AreaFormacionService {

	
	@Autowired
	public AreaFormacionRepository areaFormacionRepository;
	
	
	@Override
	public Page<AreaFormacion> findAreasFormacionWithPaginationAndSorting(Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		return areaFormacionRepository.findAreasFormacionWithPaginationAndSorting(page, pageSize, field, asc);
	}
	
	
	@Override
	public AreaFormacion findAreaFormacionById(Integer id)
			throws Exception {
		return areaFormacionRepository.findAreaFormacionById(id);
	}
	
	
	@Override
	public Page<AreaFormacion> findAreasFormacionByNameAndWithPaginationAndSorting(String nombre, Integer page, Integer pageSize, String field, boolean asc)
			throws Exception {
		return areaFormacionRepository.findAreasFormacionByNameAndWithPaginationAndSorting(nombre, page, pageSize, field, asc);
	}


	@Override
	public Page<AreaFormacion> findAreasFormacionByIdCampoFormacionAndWithPaginationAndSorting(Integer idCampoFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		return areaFormacionRepository.findAreasFormacionByIdCampoFormacionAndWithPaginationAndSorting(idCampoFormacion, page, pageSize, field, asc);
	}
	
	
	@Override
	public Page<AreaFormacion> findAreasFormacionByNombreCampoFormacionAndWithPaginationAndSorting(String nombreCampoFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		return areaFormacionRepository.findAreasFormacionByNombreCampoFormacionAndWithPaginationAndSorting(nombreCampoFormacion, page, pageSize, field, asc);
	}
	
}
