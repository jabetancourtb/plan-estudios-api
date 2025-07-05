package com.udistrital.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.udistrital.entity.Asignatura;
import com.udistrital.repository.AsignaturaRepository;
import com.udistrital.repository.jpa.AsignaturaJpaRepository;


@Repository
public class AsignaturaRepositoryImpl implements AsignaturaRepository {
	
	@Autowired
	public AsignaturaJpaRepository asignaturaJpaRepository;
	

	@Override
	public Asignatura saveAsignatura(Asignatura asignatura) throws Exception {
		return asignaturaJpaRepository.save(asignatura);
	}
	

	@Override
	public List<Asignatura> saveAsignaturas(List<Asignatura> asignaturas) throws Exception {
		return asignaturaJpaRepository.saveAll(asignaturas);
	}

	
	@Override
	public void deleteAsignaturaByCodigo(Integer codigoAsignatura) throws Exception {
		asignaturaJpaRepository.deleteById(codigoAsignatura);
	}

	
	@Override
	public Asignatura findAsignaturaByCodigo(Integer codigoAsignatura) throws Exception {
		return asignaturaJpaRepository.findById(codigoAsignatura).orElse(null);
	}

	
	@Override
	public Page<Asignatura> findAsignaturasWithPaginationAndSorting(Integer page, Integer pageSize, String field,
			boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return asignaturaJpaRepository.findAll(PageRequest.of(page, pageSize).withSort(sorting));
	}


	// ASIGNATURAS POR CARRERA
	@Override
	public Page<Asignatura> findAsignaturasByCarreraAndWithPaginationAndSorting(String carrera, Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return asignaturaJpaRepository.findAsignaturasByCarreraAndWithPaginationAndSorting(carrera, PageRequest.of(page, pageSize).withSort(sorting));
	}


	// ASIGNATURAS POR CAMPO DE FORMACIÓN
	@Override
	public Page<Asignatura> findAsignaturasByCampoFormacionAndWithPaginationAndSorting(String campoFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return asignaturaJpaRepository.findAsignaturasByCampoFormacionAndWithPaginationAndSorting(campoFormacion, PageRequest.of(page, pageSize).withSort(sorting));
	}
	
	
	// ASIGNATURAS POR ÁREA DE FORMACIÓN
	@Override
	public Page<Asignatura> findAsignaturasByAreaFormacionWithPaginationAndSorting(String areaFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return asignaturaJpaRepository.findAsignaturasByAreaFormacionWithPaginationAndSorting(areaFormacion, PageRequest.of(page, pageSize).withSort(sorting));
	}
		


	// ASIGNATURAS POR CAMPO DE FORMACIÓN Y ÁREA DE FORMACIÓN
	@Override
	public Page<Asignatura> findAsignaturasByAreaFormacionAndCampoFormacionWithPaginationAndSorting(String campoFormacion, String areaFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return asignaturaJpaRepository.findAsignaturasByAreaFormacionAndCampoFormacionWithPaginationAndSorting(campoFormacion, areaFormacion, PageRequest.of(page, pageSize).withSort(sorting));
	}
	
	
	// ASIGNATURAS POR CAMPO DE FORMACIÓN Y ÁREA DE FORMACIÓN ELECTIVAS
	@Override
	public Page<Asignatura> findAsignaturasByAreaFormacionElectivasAndCampoFormacionWithPaginationAndSorting(String campoFormacion, String areaFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return asignaturaJpaRepository.findAsignaturasByAreaFormacionElectivasAndCampoFormacionWithPaginationAndSorting(campoFormacion, areaFormacion, PageRequest.of(page, pageSize).withSort(sorting));
	}
	
	
	// ASIGNATURAS POR SEMESTRE
	@Override
	public Page<Asignatura> findAsignaturasBySemestreAndWithPaginationAndSorting(Integer semestre, Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		Sort sorting = Sort.by(field);
		
		if(!asc) {
			sorting = Sort.by(field).descending();
		}

		return asignaturaJpaRepository.findAsignaturasBySemestreAndWithPaginationAndSorting(semestre, PageRequest.of(page, pageSize).withSort(sorting));
	}
	
	
	// SEMESTRES
	@Override
	public Page<Integer> findSemestresWithPaginationAndSorting(boolean asc) throws Exception {
		Sort sorting = Sort.by("semestre");
		
		if(!asc) {
			sorting = Sort.by("semestre").descending();
		}

		return asignaturaJpaRepository.findSemestresWithPaginationAndSorting(PageRequest.of(0, 100).withSort(sorting));
	}

}
