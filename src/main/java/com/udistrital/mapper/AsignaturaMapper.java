package com.udistrital.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;

import com.udistrital.dto.AsignaturaDTO;
import com.udistrital.entity.Asignatura;


@Mapper(componentModel = "spring")
public interface AsignaturaMapper {

	Asignatura asignaturaDTOToAsignatura(AsignaturaDTO asignaturaDTO) throws Exception;

	List<Asignatura> asignaturaDTOListToAsignaturaList(List<AsignaturaDTO> asignaturaDTOList) throws Exception;
	
	AsignaturaDTO asignaturaToAsignaturaDTO(Asignatura asignatura) throws Exception;
	
	List<AsignaturaDTO> asignaturaListToAsignaturaDTOList(List<Asignatura> asignaturaList) throws Exception;
	
	Set<Asignatura> asignaturaDTOSetToAsignaturaSet(Set<AsignaturaDTO> asignaturaDtoSet) throws Exception;
			
}
