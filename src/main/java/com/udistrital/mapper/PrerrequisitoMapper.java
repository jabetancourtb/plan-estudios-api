package com.udistrital.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.udistrital.dto.PrerrequisitoDTO;
import com.udistrital.entity.Prerrequisito;

@Mapper(componentModel = "spring")
public interface PrerrequisitoMapper {
	
	List<Prerrequisito> prerrequisitoDTOListToPrerrequisitoList(List<PrerrequisitoDTO> prerrequisitoDTOList) throws Exception;
	
	List<PrerrequisitoDTO> prerrequisitoListToPrerrequisitoDTOList(List<Prerrequisito> prerrequisitoList) throws Exception;

}
