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
	public Page<Prerrequisito> findAsignaturasPrerrequisitosWithPaginationAndSorting(Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		return prerrequisitoRepository.findAsignaturasPrerrequisitosWithPaginationAndSorting(page, pageSize, field, asc);
	}

	
	@Override
	public Page<Prerrequisito> findPrerrequisitosByCodigoPrerrequisitoWithPaginationAndSorting(
			Integer codigoPrerrequisito, Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		return prerrequisitoRepository.findPrerrequisitosByCodigoPrerrequisitoWithPaginationAndSorting(codigoPrerrequisito, page, pageSize, field, asc);
	}

	
	@Override
	public Page<Prerrequisito> findPrerrequisitosByCodigoAsignaturaWithPaginationAndSorting(Integer codigoAsignatura, Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		return prerrequisitoRepository.findPrerrequisitosByCodigoAsignaturaWithPaginationAndSorting(codigoAsignatura, page, pageSize, field, asc);
	}

}
