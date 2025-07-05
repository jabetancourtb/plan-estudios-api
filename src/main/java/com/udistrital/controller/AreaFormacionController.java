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
import com.udistrital.dto.AreaFormacionDTO;
import com.udistrital.entity.AreaFormacion;
import com.udistrital.enumeration.ExceptionType;
import com.udistrital.exception.APIException;
import com.udistrital.mapper.AreaFormacionMapper;
import com.udistrital.service.AreaFormacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping
@Tag(name = "Áreas de formación", description = "Api que contiene los servicios para las áreas de formación.")
public class AreaFormacionController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(AreaFormacionController.class);

	@Autowired
	private AreaFormacionMapper areaFormacionMapper;
	
	@Autowired
	private AreaFormacionService areaFormacionService;
	
	
	@Operation(summary = "Buscar áreas de formación")
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
	@GetMapping(URIConstants.AREAS_FORMACION)
	public ResponseEntity<?> findAreasFormacionAndWithPaginationAndSorting(
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<AreaFormacion> areaFormacionListEntity = areaFormacionService.findAreasFormacionWithPaginationAndSorting(page, pageSize, field, asc);
			
			List<AreaFormacionDTO> areaFormacionListDTO = areaFormacionMapper.areaFormacionListToAreaFormacionDTOList(areaFormacionListEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(areaFormacionListDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(areaFormacionListEntity.getSize())
					.totalRecordCount(areaFormacionListEntity.getTotalElements())
					.totalPages(areaFormacionListEntity.getTotalPages())
					.content(areaFormacionListDTO)
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
	
	
	@Operation(summary = "Buscar área de formación por id")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "204", description = "No content", content =  @Content),
        @ApiResponse(responseCode = "200", description = "Successful operation", 
        		content = { @Content(mediaType = "application/json", 
        	    schema = @Schema(implementation = AreaFormacionDTO.class)) }
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
	@GetMapping(URIConstants.AREAS_FORMACION+"/{id}")
	public ResponseEntity<?> findAreaFormacionsByIdAndWithPaginationAndSorting(@PathVariable Integer id) throws Exception {
		try {
			
			AreaFormacion areaFormacionEntity = areaFormacionService.findAreaFormacionById(id);
			
			AreaFormacionDTO areaFormacionDTO = areaFormacionMapper.areaFormacionToAreaFormacionDTO(areaFormacionEntity);
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(areaFormacionDTO == null) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(areaFormacionDTO, httpStatus);	
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
	
	
	@Operation(summary = "Buscar áreas de formaciones por nombre")
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
	@GetMapping(URIConstants.AREAS_FORMACION+"/nombre/{name}")
	public ResponseEntity<?> findAreaFormacionsByNameAndWithPaginationAndSorting(
			@PathVariable String name,
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<AreaFormacion> areaFormacionListEntity = areaFormacionService.findAreasFormacionByNameAndWithPaginationAndSorting(name, page, pageSize, field, asc);
			
			List<AreaFormacionDTO> areaFormacionListDTO = areaFormacionMapper.areaFormacionListToAreaFormacionDTOList(areaFormacionListEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(areaFormacionListDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(areaFormacionListEntity.getSize())
					.totalRecordCount(areaFormacionListEntity.getTotalElements())
					.totalPages(areaFormacionListEntity.getTotalPages())
					.content(areaFormacionListDTO)
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
	
	
	@Operation(summary = "Buscar áreas de formaciones por id código de formación")
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
	@GetMapping(URIConstants.CAMPOS_FORMACION+"/{idCampoFormacion}"+URIConstants.AREAS_FORMACION)
	public ResponseEntity<?> findAreasFormacionByIdCampoFormacionAndWithPaginationAndSorting(
			@PathVariable Integer idCampoFormacion,
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<AreaFormacion> areaFormacionListEntity = areaFormacionService.findAreasFormacionByIdCampoFormacionAndWithPaginationAndSorting(idCampoFormacion, page, pageSize, field, asc);
			
			List<AreaFormacionDTO> areaFormacionListDTO = areaFormacionMapper.areaFormacionListToAreaFormacionDTOList(areaFormacionListEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(areaFormacionListDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(areaFormacionListEntity.getSize())
					.totalRecordCount(areaFormacionListEntity.getTotalElements())
					.totalPages(areaFormacionListEntity.getTotalPages())
					.content(areaFormacionListDTO)
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
