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
		
		Page<Asignatura> response = asignaturaRepository.findAsignaturasWithPaginationAndSorting(page, pageSize, field, asc);
		
		// TODO pasar a un método de conversión
		List<Asignatura> asignaturas = response.getContent();
		
		asignaturas.stream().forEach(a -> {
			
			if(a.getCampoFormacion().equals("") || a.getCampoFormacion() == null) {
				a.setCampoFormacion("Otros");
			}
			
			if(a.getCampoFormacion().equals("Ciencias Básicas") && (a.getAreaFormacion().equals("Electiva") || a.getAreaFormacion().equals("Electivas"))) {
				a.setAreaFormacion("Electiva Ciencias Básicas");
			}
			else if(a.getCampoFormacion().equals("Socio humanística") && (a.getAreaFormacion().equals("Electiva") || a.getAreaFormacion().equals("Electivas"))) {
				a.setAreaFormacion("Electiva Socio humanística");
			}
			else if(a.getCampoFormacion().equals("Ingeniería Aplicada") && (a.getAreaFormacion().equals("Electiva") || a.getAreaFormacion().equals("Electivas"))) {
				a.setAreaFormacion("Electiva Ingeniería Aplicada");
			}
			else if(a.getCampoFormacion().equals("Económico Administrativa") && (a.getAreaFormacion().equals("Electiva") || a.getAreaFormacion().equals("Electivas"))) {
				a.setAreaFormacion("Electiva Económico Administrativa");
			}
			else if(a.getAreaFormacion().equals("") || a.getAreaFormacion() == null) {
				a.setAreaFormacion("Otros");
			}
		});
		
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


	// SEMESTRES
	@Override
	public Page<Integer> findSemestresWithPaginationAndSorting(boolean asc) throws Exception {
		return asignaturaRepository.findSemestresWithPaginationAndSorting(asc);
	}

}
