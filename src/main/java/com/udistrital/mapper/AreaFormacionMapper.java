package com.udistrital.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.udistrital.dto.AreaFormacionDTO;
import com.udistrital.entity.AreaFormacion;


@Mapper(componentModel = "spring")
public interface AreaFormacionMapper {

	@Mappings({@Mapping(source = "campoFormacion.id", target = "idCampoFormacion")})
	AreaFormacionDTO areaFormacionToAreaFormacionDTO(AreaFormacion areaFormacion) throws Exception;

	List<AreaFormacionDTO> areaFormacionListToAreaFormacionDTOList(List<AreaFormacion> areaFormacionList) throws Exception;
	
}
