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
import com.udistrital.dto.CampoFormacionDTO;
import com.udistrital.entity.CampoFormacion;
import com.udistrital.enumeration.ExceptionType;
import com.udistrital.exception.APIException;
import com.udistrital.mapper.CampoFormacionMapper;
import com.udistrital.service.CampoFormacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping
@Tag(name = "Campos de formación", description = "Api que contiene los servicios para los campos de formación.")
public class CampoFormacionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CampoFormacionController.class);

	@Autowired
	private CampoFormacionMapper campoFormacionMapper;
	
	@Autowired
	private CampoFormacionService campoFormacionService;
		
	
	@Operation(summary = "Buscar campos de formación")
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
	@GetMapping(URIConstants.CAMPOS_FORMACION)
	public ResponseEntity<?> findCamposFormacionAndWithPaginationAndSorting(
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<CampoFormacion> campoFormacionListEntity = campoFormacionService.findCamposFormacionWithPaginationAndSorting(page, pageSize, field, asc);
			
			List<CampoFormacionDTO> campoFormacionListDTO = campoFormacionMapper.campoFormacionListToCampoFormacionDTOList(campoFormacionListEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(campoFormacionListDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(campoFormacionListEntity.getSize())
					.totalRecordCount(campoFormacionListEntity.getTotalElements())
					.totalPages(campoFormacionListEntity.getTotalPages())
					.content(campoFormacionListDTO)
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
	
	
	@Operation(summary = "Buscar campos de formaciones por id")
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
	@GetMapping(URIConstants.CAMPOS_FORMACION+"/{id}")
	public ResponseEntity<?> findCampoFormacionsByIdAndWithPaginationAndSorting(
			@PathVariable Integer id,
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<CampoFormacion> campoFormacionListEntity = campoFormacionService.findCamposFormacionByIdAndWithPaginationAndSorting(id, page, pageSize, field, asc);
			
			List<CampoFormacionDTO> campoFormacionListDTO = campoFormacionMapper.campoFormacionListToCampoFormacionDTOList(campoFormacionListEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(campoFormacionListDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(campoFormacionListEntity.getSize())
					.totalRecordCount(campoFormacionListEntity.getTotalElements())
					.totalPages(campoFormacionListEntity.getTotalPages())
					.content(campoFormacionListDTO)
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
	
	
	@Operation(summary = "Buscar campos de formaciones por nombre")
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
	@GetMapping(URIConstants.CAMPOS_FORMACION+"/nombre/{name}")
	public ResponseEntity<?> findCampoFormacionsByNameAndWithPaginationAndSorting(
			@PathVariable String name,
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<CampoFormacion> campoFormacionListEntity = campoFormacionService.findCamposFormacionByNameAndWithPaginationAndSorting(name, page, pageSize, field, asc);
			
			List<CampoFormacionDTO> campoFormacionListDTO = campoFormacionMapper.campoFormacionListToCampoFormacionDTOList(campoFormacionListEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(campoFormacionListDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(campoFormacionListEntity.getSize())
					.totalRecordCount(campoFormacionListEntity.getTotalElements())
					.totalPages(campoFormacionListEntity.getTotalPages())
					.content(campoFormacionListDTO)
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
