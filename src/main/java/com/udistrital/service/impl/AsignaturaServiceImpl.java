package com.udistrital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.udistrital.constants.AreaFormacionConstans;
import com.udistrital.constants.CamposFormacionConstants;
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
		
		Asignatura a = asignaturaRepository.findAsignaturaByCodigo(codigoAsignatura);
		
		if(a.getCampoFormacion().equals("") || a.getCampoFormacion() == null) {
			a.setCampoFormacion(CamposFormacionConstants.OTROS);
		}
		
		if(a.getCampoFormacion().equals(CamposFormacionConstants.CIENCIAS_BASICAS) && (a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVA) || a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVAS))) {
			a.setAreaFormacion(AreaFormacionConstans.ELECTIVA_CIENCIAS_BASICAS);
		}
		else if(a.getCampoFormacion().equals(CamposFormacionConstants.SOCIO_HUMANISTICA) && (a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVA) || a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVAS))) {
			a.setAreaFormacion(AreaFormacionConstans.ELECTIVA_SOCIO_HUMANISTICA);
		}
		else if(a.getCampoFormacion().equals(CamposFormacionConstants.INGENIERIA_APLICADA) && (a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVA) || a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVAS))) {
			a.setAreaFormacion(AreaFormacionConstans.ELECTIVA_INEGNEIRIA_APLICADA);
		}
		else if(a.getCampoFormacion().equals(CamposFormacionConstants.ECONOMICO_ADMINISTRATIVA) && (a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVA) || a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVAS))) {
			a.setAreaFormacion(AreaFormacionConstans.ELECTIVA_ECONOMICO_ADMINISTRATIVA);
		}
		else if(a.getAreaFormacion().equals("") || a.getAreaFormacion() == null) {
			a.setAreaFormacion(AreaFormacionConstans.OTROS);
		}
		
		return a;
	}

	
	@Override
	public Page<Asignatura> findAsignaturasWithPaginationAndSorting(Integer page, Integer pageSize, String field,
			boolean asc) throws Exception {
		return validateFields(asignaturaRepository.findAsignaturasWithPaginationAndSorting(page, pageSize, field, asc));
	}


	// INICIO ASIGNATURAS POR CARRERA
	@Override
	public Page<Asignatura> findAsignaturasByCarreraAndWithPaginationAndSorting(String carrera, Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		return validateFields(asignaturaRepository.findAsignaturasByCarreraAndWithPaginationAndSorting(carrera, page, pageSize, field, asc));
	}


	// ASIGNATURAS POR CAMPO DE FORMACIÓN
	@Override
	public Page<Asignatura> findAsignaturasByCampoFormacionAndWithPaginationAndSorting(String campoFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		return validateFields(asignaturaRepository.findAsignaturasByCampoFormacionAndWithPaginationAndSorting(campoFormacion, page, pageSize, field, asc));
	}
	
	
	// ASIGNATURAS POR ÁREA DE FORMACIÓN
	@Override
	public Page<Asignatura> findAsignaturasByAreaFormacionWithPaginationAndSorting(String areaFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {		
		return validateFields(asignaturaRepository.findAsignaturasByAreaFormacionWithPaginationAndSorting(areaFormacion, page, pageSize, field, asc));
	}

	
	// ASIGNATURAS POR CAMPO DE FORMACIÓN Y ÁREA DE FORMACIÓN
	@Override
	public Page<Asignatura> findAsignaturasByAreaFormacionAndCampoFormacionWithPaginationAndSorting(String campoFormacion, String areaFormacion,
			Integer page, Integer pageSize, String field, boolean asc) throws Exception {
		return validateFields(asignaturaRepository.findAsignaturasByAreaFormacionAndCampoFormacionWithPaginationAndSorting(campoFormacion, areaFormacion, page, pageSize, field, asc));
	}

	
	// ASIGNATURAS POR SEMESTRE
	@Override
	public Page<Asignatura> findAsignaturasBySemestreAndWithPaginationAndSorting(Integer semestre, Integer page,
			Integer pageSize, String field, boolean asc) throws Exception {
		return validateFields(asignaturaRepository.findAsignaturasBySemestreAndWithPaginationAndSorting(semestre, page, pageSize, field, asc));
	}


	// SEMESTRES
	@Override
	public Page<Integer> findSemestresWithPaginationAndSorting(boolean asc) throws Exception {
		return asignaturaRepository.findSemestresWithPaginationAndSorting(asc);
	}
	
	
	private Page<Asignatura> validateFields(Page<Asignatura> asignaturasPerPage) {
		
		List<Asignatura> asignaturas = asignaturasPerPage.getContent();
		
		asignaturas.stream().forEach(a -> {
			
			if(a.getCampoFormacion().equals("") || a.getCampoFormacion() == null) {
				a.setCampoFormacion(CamposFormacionConstants.OTROS);
			}
			
			if(a.getCampoFormacion().equals(CamposFormacionConstants.CIENCIAS_BASICAS) && (a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVA) || a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVAS))) {
				a.setAreaFormacion(AreaFormacionConstans.ELECTIVA_CIENCIAS_BASICAS);
			}
			else if(a.getCampoFormacion().equals(CamposFormacionConstants.SOCIO_HUMANISTICA) && (a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVA) || a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVAS))) {
				a.setAreaFormacion(AreaFormacionConstans.ELECTIVA_SOCIO_HUMANISTICA);
			}
			else if(a.getCampoFormacion().equals(CamposFormacionConstants.INGENIERIA_APLICADA) && (a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVA) || a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVAS))) {
				a.setAreaFormacion(AreaFormacionConstans.ELECTIVA_INEGNEIRIA_APLICADA);
			}
			else if(a.getCampoFormacion().equals(CamposFormacionConstants.ECONOMICO_ADMINISTRATIVA) && (a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVA) || a.getAreaFormacion().equals(AreaFormacionConstans.ELECTIVAS))) {
				a.setAreaFormacion(AreaFormacionConstans.ELECTIVA_ECONOMICO_ADMINISTRATIVA);
			}
			else if(a.getAreaFormacion().equals("") || a.getAreaFormacion() == null) {
				a.setAreaFormacion(AreaFormacionConstans.OTROS);
			}
		});
		
		return asignaturasPerPage;
	}

}
