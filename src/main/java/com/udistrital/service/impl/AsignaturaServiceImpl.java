package com.udistrital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.udistrital.entity.Asignatura;
import com.udistrital.repository.AsignaturaRepository;
import com.udistrital.service.AsignaturaService;


@Service
public class AsignaturaServiceImpl implements AsignaturaService {
	
	@Autowired
	public AsignaturaRepository asignaturaRepository;

	@Override
	public Asignatura saveAsignatura(Asignatura asignatura) throws Exception {
		return asignaturaRepository.saveAsignatura(asignatura);
	}
	

	@Override
	public List<Asignatura> saveAsignaturas(List<Asignatura> asignaturas) throws Exception {
		return asignaturaRepository.saveAsignaturas(asignaturas);
	}

	
	@Override
	public void deleteAsignaturaByCodigo(Integer codigoAsignatura) throws Exception {
		asignaturaRepository.deleteAsignaturaByCodigo(codigoAsignatura);		
	}

	
	@Override
	public Asignatura findAsignaturaByCodigo(Integer codigoAsignatura) throws Exception {
		return asignaturaRepository.findAsignaturaByCodigo(codigoAsignatura);
	}

	
	@Override
	public Page<Asignatura> findAsignaturasWithPaginationAndSorting(Integer page, Integer pageSize, String field,
			boolean asc) throws Exception {
		return asignaturaRepository.findAsignaturasWithPaginationAndSorting(page, pageSize, field, asc);
	}


	// INICIO ASIGNATURAS POR CARRERA
	@Override
	public Page<Asignatura> findAsignaturasByCarreraAndWithPaginationAndSorting(String carrera, Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		return asignaturaRepository.findAsignaturasByCarreraAndWithPaginationAndSorting(carrera, page, pageSize, field, asc);
	}


	// ASIGNATURAS POR CAMPO DE FORMACIÓN
	@Override
	public Page<Asignatura> findAsignaturasByCampoFormacionAndWithPaginationAndSorting(String campoFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		return asignaturaRepository.findAsignaturasByCampoFormacionAndWithPaginationAndSorting(campoFormacion, page, pageSize, field, asc);
	}

	
	// ASIGNATURAS POR ÁREA DE FORMACIÓN
	@Override
	public Page<Asignatura> findAsignaturasByAreaFormacionAndWithPaginationAndSorting(String areaFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		return asignaturaRepository.findAsignaturasByAreaFormacionAndWithPaginationAndSorting(areaFormacion, page, pageSize, field, asc);
	}

	
	// ASIGNATURAS POR SEMESTRE
	@Override
	public Page<Asignatura> findAsignaturasBySemestreAndWithPaginationAndSorting(Integer semestre, Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		return asignaturaRepository.findAsignaturasBySemestreAndWithPaginationAndSorting(semestre, page, pageSize, field, asc);
	}


	// CAMPOS DE FORMACIÓN
	@Override
	public Page<Asignatura> findCamposFormacionAndWithPaginationAndSorting(Integer page, Integer pageSize, String field,
			boolean asc) throws Exception {
		return asignaturaRepository.findCamposFormacionAndWithPaginationAndSorting(page, pageSize, field, asc);
	}


	// ÁREAS DE FORMACIÓN
	@Override
	public Page<Asignatura> findAreasFormacionAndWithPaginationAndSorting(Integer page, Integer pageSize, String field,
			boolean asc) throws Exception {
		return asignaturaRepository.findAreasFormacionAndWithPaginationAndSorting(page, pageSize, field, asc);
	}


	// SEMESTRES
	@Override
	public Page<Asignatura> findSemestresAndWithPaginationAndSorting(Integer page, Integer pageSize, String field,
			boolean asc) throws Exception {
		return asignaturaRepository.findSemestresAndWithPaginationAndSorting(page, pageSize, field, asc);
	}

}
