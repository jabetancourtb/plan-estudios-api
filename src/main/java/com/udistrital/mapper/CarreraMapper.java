package com.udistrital.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.udistrital.dto.CarreraDTO;
import com.udistrital.entity.Carrera;


@Mapper(componentModel = "spring")
public interface CarreraMapper {
	
	CarreraDTO carreraToCarreraDTO(Carrera carrera) throws Exception;

	List<CarreraDTO> carreraListToCarreraDTOList(List<Carrera> carreraList) throws Exception;
	
}
