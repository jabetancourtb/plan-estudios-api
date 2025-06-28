package com.udistrital.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.udistrital.dto.CampoFormacionDTO;
import com.udistrital.entity.CampoFormacion;


@Mapper(componentModel = "spring")
public interface CampoFormacionMapper {

	CampoFormacionDTO campoFormacionToCampoFormacionDTO(CampoFormacion campoFormacion) throws Exception;

	List<CampoFormacionDTO> campoFormacionListToCampoFormacionDTOList(List<CampoFormacion> campoFormacionList) throws Exception;
	
}
