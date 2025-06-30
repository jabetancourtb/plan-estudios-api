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
import com.udistrital.dto.PrerrequisitoDTO;
import com.udistrital.entity.Prerrequisito;
import com.udistrital.enumeration.ExceptionType;
import com.udistrital.exception.APIException;
import com.udistrital.mapper.PrerrequisitoMapper;
import com.udistrital.service.PrerrequisitoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping
@Tag(name = "Asignatura prerrequisito", description = "Api que contiene los servicios para los prerrequisitos de las asignaturas.")
public class PrerrequisitoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PrerrequisitoController.class);

	@Autowired
	private PrerrequisitoMapper prerrequisitoMapper;
	
	@Autowired
	private PrerrequisitoService prerrequisitoService;
	
	
	@Operation(summary = "Buscar asignaturas y prerrequisitos por paginación y campo")
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
	@GetMapping(URIConstants.PRERREQUISITOS)
	public ResponseEntity<?> findAsignaturasPrerrequisitosWithPaginationAndSorting(
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "prerrequisito_codigo", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<Prerrequisito> prerrequisitoListEntity = prerrequisitoService.findAsignaturasPrerrequisitosWithPaginationAndSorting(page, pageSize, field, asc);
			
			List<PrerrequisitoDTO> prerrequisitoListDTO = prerrequisitoMapper.prerrequisitoListToPrerrequisitoDTOList(prerrequisitoListEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(prerrequisitoListDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(prerrequisitoListEntity.getSize())
					.totalRecordCount(prerrequisitoListEntity.getTotalElements())
					.totalPages(prerrequisitoListEntity.getTotalPages())
					.content(prerrequisitoListDTO)
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
	
	
	@Operation(summary = "Buscar asignaturas prerrequisitos por código, paginación y campo")
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
	@GetMapping(URIConstants.PRERREQUISITOS+"/{codigoPrerrequisito}")
	public ResponseEntity<?> findPrerrequisitosByCodigoPrerrequisitoWithPaginationAndSorting(
			@PathVariable Integer codigoPrerrequisito,
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "prerrequisito_codigo", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<Prerrequisito> prerrequisitoListEntity = prerrequisitoService.findPrerrequisitosByCodigoPrerrequisitoWithPaginationAndSorting(codigoPrerrequisito, page, pageSize, field, asc);
			
			List<PrerrequisitoDTO> prerrequisitoListDTO = prerrequisitoMapper.prerrequisitoListToPrerrequisitoDTOList(prerrequisitoListEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(prerrequisitoListDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(prerrequisitoListEntity.getSize())
					.totalRecordCount(prerrequisitoListEntity.getTotalElements())
					.totalPages(prerrequisitoListEntity.getTotalPages())
					.content(prerrequisitoListDTO)
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
	
	
	@Operation(summary = "Buscar asignaturas y sus prerrequisitos por código de asignatura, paginación y campo")
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
	@GetMapping(URIConstants.ASIGNATURAS+"/{codigoAsignatura}"+URIConstants.PRERREQUISITOS)
	public ResponseEntity<?> findAsignaturaByCodigoWithPaginationAndSorting(
			@PathVariable Integer codigoAsignatura,
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "asignatura_codigo", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<Prerrequisito> prerrequisitoListEntity = prerrequisitoService.findPrerrequisitosByCodigoAsignaturaWithPaginationAndSorting(codigoAsignatura, page, pageSize, field, asc);
			
			List<PrerrequisitoDTO> prerrequisitoListDTO = prerrequisitoMapper.prerrequisitoListToPrerrequisitoDTOList(prerrequisitoListEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(prerrequisitoListDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(prerrequisitoListEntity.getSize())
					.totalRecordCount(prerrequisitoListEntity.getTotalElements())
					.totalPages(prerrequisitoListEntity.getTotalPages())
					.content(prerrequisitoListDTO)
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
