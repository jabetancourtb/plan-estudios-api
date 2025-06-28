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
import com.udistrital.dto.AsignaturaDTO;
import com.udistrital.entity.Asignatura;
import com.udistrital.enumeration.ExceptionType;
import com.udistrital.exception.APIException;
import com.udistrital.mapper.AsignaturaMapper;
import com.udistrital.service.AsignaturaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping
@Tag(name = "Asignatura", description = "Api que contiene los servicios para las asignaturas.")
public class AsignaturaController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AsignaturaController.class);

	@Autowired
	private AsignaturaMapper asignaturaMapper;
	
	@Autowired
	private AsignaturaService asignaturaService;
	
	
	// INICIO ASIGNATURAS
	@Operation(summary = "Buscar asignatura por código")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "204", description = "No content", content =  @Content),
        @ApiResponse(responseCode = "200", description = "Successful operation", 
        		content = { @Content(mediaType = "application/json", 
        	    schema = @Schema(implementation = AsignaturaDTO.class)) }
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
	@GetMapping(URIConstants.ASIGNATURAS+"/{codigoAsignatura}")
	public ResponseEntity<?> findAsignaturaByGuid(@PathVariable Integer codigoAsignatura) throws Exception {
		
		try {
			Asignatura asignaturaEntity = asignaturaService.findAsignaturaByCodigo(codigoAsignatura);
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(asignaturaEntity == null) {
				httpStatus = HttpStatus.NO_CONTENT;
			}
			
			AsignaturaDTO asignaturaSimpledDTO = asignaturaMapper.asignaturaToAsignaturaDTO(asignaturaEntity);
				
			return new ResponseEntity<>(asignaturaSimpledDTO, httpStatus);	
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
	

	@Operation(summary = "Buscar asignaturas por paginación y campo")
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
	@GetMapping(URIConstants.ASIGNATURAS)
	public ResponseEntity<?> findAsignaturasWithPaginationAndSorting(
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "codigo", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<Asignatura> asignaturasEntity = asignaturaService.findAsignaturasWithPaginationAndSorting(page, pageSize, field, asc);
			
			List<AsignaturaDTO> asignaturasSimpleDTO = asignaturaMapper.asignaturaListToAsignaturaDTOList(asignaturasEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(asignaturasSimpleDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(asignaturasEntity.getSize())
					.totalRecordCount(asignaturasEntity.getTotalElements())
					.totalPages(asignaturasEntity.getTotalPages())
					.content(asignaturasSimpleDTO)
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
	// FIN ASIGNATURAS
	
	
	// INICIO ASIGNATURAS POR CARRERA
	@Operation(summary = "Buscar asignaturas por carrera")
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
	@GetMapping(URIConstants.CARRERAS+"/{carrera}"+URIConstants.ASIGNATURAS)
	public ResponseEntity<?> findAsignaturasByCarreraAndWithPaginationAndSorting(
			@PathVariable String carrera, 
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "codigo", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<Asignatura> asignaturasEntity = asignaturaService.findAsignaturasByCarreraAndWithPaginationAndSorting(carrera, page, pageSize, field, asc);
			
			List<AsignaturaDTO> asignaturasSimpleDTO = asignaturaMapper.asignaturaListToAsignaturaDTOList(asignaturasEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(asignaturasSimpleDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(asignaturasEntity.getSize())
					.totalRecordCount(asignaturasEntity.getTotalElements())
					.totalPages(asignaturasEntity.getTotalPages())
					.content(asignaturasSimpleDTO)
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
	// FIN ASIGNATURAS POR CARRERA
	
	
	// INICIO ASIGNATURAS POR CAMPO DE FORMACIÓN
	@Operation(summary = "Buscar asignaturas por campo de formación")
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
	@GetMapping(URIConstants.CAMPOS_FORMACION+"/{campoFormacion}"+URIConstants.ASIGNATURAS)
	public ResponseEntity<?> findAsignaturasByCampoFormacionAndWithPaginationAndSorting(
			@PathVariable String campoFormacion, 
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "codigo", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<Asignatura> asignaturasEntity = asignaturaService.findAsignaturasByCampoFormacionAndWithPaginationAndSorting(campoFormacion, page, pageSize, field, asc);
			
			List<AsignaturaDTO> asignaturasSimpleDTO = asignaturaMapper.asignaturaListToAsignaturaDTOList(asignaturasEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(asignaturasSimpleDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(asignaturasEntity.getSize())
					.totalRecordCount(asignaturasEntity.getTotalElements())
					.totalPages(asignaturasEntity.getTotalPages())
					.content(asignaturasSimpleDTO)
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
	// FIN ASIGNATURAS POR CAMPO DE FORMACIÓN
	
	
	// INICIO ASIGNATURAS POR ÁREA DE FORMACIÓN
	@Operation(summary = "Buscar asignaturas por área de formación")
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
	@GetMapping(URIConstants.AREAS_FORMACION+"/{areaFormacion}"+URIConstants.ASIGNATURAS)
	public ResponseEntity<?> findAsignaturasByAreaFormacionAndWithPaginationAndSorting(
			@PathVariable String areaFormacion, 
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "codigo", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<Asignatura> asignaturasEntity = asignaturaService.findAsignaturasByAreaFormacionAndWithPaginationAndSorting(areaFormacion, page, pageSize, field, asc);
			
			List<AsignaturaDTO> asignaturasSimpleDTO = asignaturaMapper.asignaturaListToAsignaturaDTOList(asignaturasEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(asignaturasSimpleDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(asignaturasEntity.getSize())
					.totalRecordCount(asignaturasEntity.getTotalElements())
					.totalPages(asignaturasEntity.getTotalPages())
					.content(asignaturasSimpleDTO)
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
	// FIN ASIGNATURAS POR ÁREA DE FORMACIÓN
	
	
	// INICIO ASIGNATURAS POR SEMESTRE
	@Operation(summary = "Buscar asignaturas por semestre")
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
	@GetMapping(URIConstants.SEMESTRES+"/{semestre}"+URIConstants.ASIGNATURAS)
	public ResponseEntity<?> findAsignaturasBySemestreAndWithPaginationAndSorting(
			@PathVariable Integer semestre, 
			@RequestParam(defaultValue = "1") Integer page, 
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "codigo", required = false) String field,
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {
			page = page - 1;
			
			Page<Asignatura> asignaturasEntity = asignaturaService.findAsignaturasBySemestreAndWithPaginationAndSorting(semestre, page, pageSize, field, asc);
			
			List<AsignaturaDTO> asignaturasSimpleDTO = asignaturaMapper.asignaturaListToAsignaturaDTOList(asignaturasEntity.getContent());
			
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(asignaturasSimpleDTO.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(asignaturasEntity.getSize())
					.totalRecordCount(asignaturasEntity.getTotalElements())
					.totalPages(asignaturasEntity.getTotalPages())
					.content(asignaturasSimpleDTO)
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
	// FIN ASIGNATURAS POR SEMESTRE
	
	
	// INICIO SEMESTRES
	@Operation(summary = "Buscar semestres")
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
	@GetMapping(URIConstants.SEMESTRES)
	public ResponseEntity<?> findSemestresAndWithPaginationAndSorting(
			@RequestParam(defaultValue = "true", required = false) boolean asc) throws Exception {
		try {

			Page<Integer> semestres = asignaturaService.findSemestresWithPaginationAndSorting(asc);
						
			HttpStatus httpStatus = HttpStatus.OK;
			
			if(semestres.isEmpty()) {
				httpStatus = HttpStatus.NO_CONTENT;
			}

			return new ResponseEntity<>(
					APIResponseDTO.builder()
					.recordCountPerPage(semestres.getSize())
					.totalRecordCount(semestres.getTotalElements())
					.totalPages(semestres.getTotalPages())
					.content(semestres.getContent())
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
	// FIN SEMESTRES
	
}
