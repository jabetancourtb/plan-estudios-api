package com.udistrital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.udistrital.entity.Prerrequisito;
import com.udistrital.repository.PrerrequisitoRepository;
import com.udistrital.service.PrerrequisitoService;


@Service
public class PrerrequisitoServiceImpl implements PrerrequisitoService {
	
	@Autowired
	private PrerrequisitoRepository prerrequisitoRepository;

	
	@Override
	public Page<Prerrequisito> findPrerrequisitosWithPaginationAndSorting(Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		return prerrequisitoRepository.findPrerrequisitosWithPaginationAndSorting(page, pageSize, field, asc);
	}

	
	@Override
	public Page<Prerrequisito> findAsignaturasAnterioresByCodigoAsignaturaWithPaginationAndSorting(
			Integer codigoPrerrequisito, Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		return prerrequisitoRepository.findAsignaturasAnterioresByCodigoAsignaturaWithPaginationAndSorting(codigoPrerrequisito, page, pageSize, field, asc);
	}

	
	@Override
	public Page<Prerrequisito> findAsignaturasPosterioresByCodigoAsignaturaWithPaginationAndSorting(Integer codigoAsignatura, Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		return prerrequisitoRepository.findAsignaturasPosterioresByCodigoAsignaturaWithPaginationAndSorting(codigoAsignatura, page, pageSize, field, asc);
	}

}
