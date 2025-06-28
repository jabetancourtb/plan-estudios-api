package com.udistrital.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.udistrital.dto.AreaFormacionDTO;
import com.udistrital.entity.AreaFormacion;


@Mapper(componentModel = "spring")
public interface AreaFormacionMapper {

	AreaFormacionDTO areaFormacionToAreaFormacionDTO(AreaFormacion areaFormacion) throws Exception;

	List<AreaFormacionDTO> areaFormacionListToAreaFormacionDTOList(List<AreaFormacion> areaFormacionList) throws Exception;
	
}
