package com.udistrital.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.constants.ExceptionMessageConstants;
import com.udistrital.constants.URIConstants;
import com.udistrital.dto.APIExceptionResponseDTO;
import com.udistrital.dto.APIResponseDTO;
import com.udistrital.dto.CarreraDTO;
import com.udistrital.entity.Carrera;
import com.udistrital.enumeration.ExceptionType;
import com.udistrital.exception.APIException;
import com.udistrital.mapper.CarreraMapper;
import com.udistrital.service.CarreraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping
@Tag(name = "Carrera", description = "Api que contiene los servicios para las carreras.")
public class CarreraController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CarreraController.class);

	@Autowired
	private CarreraMapper carreraMapper;
	
	@Autowired
	private CarreraService carreraService;
	
	
	@Operation(summary = "Buscar carreras")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "204", description = "No content", content =  @Content),
        @ApiResponse(responseCode = "200", description = "Successful operation", 
        		content = { @Content(mediaType = "application/json", 
        	    schema = @Schema(implementation = APIResponseDTO.class)) }
        ),
        @ApiResponse(responseCode = "400", description = "Bad request", 
        		content = { @Content(mediaType = "application/json", 
        	    schema = @Schema(implementation = APIExceptionResponseDTO.class)) }
        ),
        @ApiResponse(responseCode = "500", description = "Internal server error", 
		        content = { @Content(mediaType = "application/json", 
			    schema = @Schema(implementation = APIExceptionResponseDTO.class)) }
        ) 
    })
	@GetMapping(URIConstants.CARRERAS)
	public ResponseEntity<?> findCarrerasWithPaginationAndSorting(
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<Carrera> asignaturaesEntity = carreraService.findCarrerasWithPaginationAndSorting(page, pageSize, field, asc);
			
			List<CarreraDTO> carreraListDTO = carreraMapper.carreraListToCarreraDTOList(asignaturaesEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(carreraListDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(asignaturaesEntity.getSize())
					.totalRecordCount(asignaturaesEntity.getTotalElements())
					.totalPages(asignaturaesEntity.getTotalPages())
					.content(carreraListDTO)
					.build(), 
					httpStatus);	
		}
		catch(Exception exception) {
			LOGGER.error(exception.getMessage());
			
			APIExceptionResponseDTO apiExceptionResponse = APIExceptionResponseDTO.builder()
					.type(ExceptionType.SERVER_EXCEPTION.getValue())
					.message(ExceptionMessageConstants.INTERNAL_SERVER_ERROR)
					.exceptionClass(Exception.class.toString())
					.httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
			
			throw new APIException(apiExceptionResponse, 
					apiExceptionResponse.getHttpStatus().value(),
					exception);
		}
	}	
	
	
	@Operation(summary = "Buscar carreras por nombre")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "204", description = "No content", content =  @Content),
        @ApiResponse(responseCode = "200", description = "Successful operation", 
        		content = { @Content(mediaType = "application/json", 
        	    schema = @Schema(implementation = APIResponseDTO.class)) }
        ),
        @ApiResponse(responseCode = "400", description = "Bad request", 
        		content = { @Content(mediaType = "application/json", 
        	    schema = @Schema(implementation = APIExceptionResponseDTO.class)) }
        ),
        @ApiResponse(responseCode = "500", description = "Internal server error", 
		        content = { @Content(mediaType = "application/json", 
			    schema = @Schema(implementation = APIExceptionResponseDTO.class)) }
        ) 
    })
	@GetMapping(URIConstants.CARRERAS+"/{name}")
	public ResponseEntity<?> findCarrerasByNameAndWithPaginationAndSorting(
			@PathVariable String name,
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<Carrera> asignaturaesEntity = carreraService.findCarrerasByNameAndWithPaginationAndSorting(name, page, pageSize, field, asc);
			
			List<CarreraDTO> carreraListDTO = carreraMapper.carreraListToCarreraDTOList(asignaturaesEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(carreraListDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(asignaturaesEntity.getSize())
					.totalRecordCount(asignaturaesEntity.getTotalElements())
					.totalPages(asignaturaesEntity.getTotalPages())
					.content(carreraListDTO)
					.build(), 
					httpStatus);	
		}
		catch(Exception exception) {
			LOGGER.error(exception.getMessage());
			
			APIExceptionResponseDTO apiExceptionResponse = APIExceptionResponseDTO.builder()
					.type(ExceptionType.SERVER_EXCEPTION.getValue())
					.message(ExceptionMessageConstants.INTERNAL_SERVER_ERROR)
					.exceptionClass(Exception.class.toString())
					.httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
			
			throw new APIException(apiExceptionResponse, 
					apiExceptionResponse.getHttpStatus().value(),
					exception);
		}
	}	
	
	
}
