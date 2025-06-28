package com.udistrital.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;

import com.udistrital.dto.AreaFormacionDTO;
import com.udistrital.dto.AsignaturaDTO;
import com.udistrital.dto.CampoFormacionDTO;
import com.udistrital.dto.SemestreDTO;
import com.udistrital.entity.Asignatura;


@Mapper(componentModel = "spring")
public interface AsignaturaMapper {

	Asignatura asignaturaDTOToAsignatura(AsignaturaDTO asignaturaDTO) throws Exception;

	List<Asignatura> asignaturaDTOListToAsignaturaList(List<AsignaturaDTO> asignaturaDTOList) throws Exception;
	
	AsignaturaDTO asignaturaToAsignaturaDTO(Asignatura asignatura) throws Exception;
	
	List<AsignaturaDTO> asignaturaListToAsignaturaDTOList(List<Asignatura> asignaturaList) throws Exception;
	
	Set<Asignatura> asignaturaDTOSetToAsignaturaSet(Set<AsignaturaDTO> asignaturaDtoSet) throws Exception;
	
	
	// CAMPOS DE FORMACIÓN
	List<CampoFormacionDTO> campoFormacionListToCampoFormacionDTOList(List<Asignatura> asignaturaList) throws Exception;
	
	// ÁREAS DE FORMACIÓN
	List<AreaFormacionDTO> areaFormacionListToAreaFormacionDTOList(List<Asignatura> asignaturaList) throws Exception;
	
	// SEMESTRES
	List<SemestreDTO> semestreListToSemestreDTOList(List<Asignatura> asignaturaList) throws Exception;
	
}
