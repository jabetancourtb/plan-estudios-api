package com.udistrital.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.entity.Prerrequisito;

public interface PrerrequisitoJpaRepository extends JpaRepository<Prerrequisito, Integer> {

	@Query(value = "SELECT "
			+ "	   pr.id, "
			+ "	   a.codigo AS asignatura_anterior_codigo, "
			+ "    a.semestre_asignatura AS asignatura_anterior_semestre, "
			+ "    a.nombre AS asignatura_anterior_nombre, "
			+ "    p.codigo AS asignatura_posterior_codigo, "
			+ "    p.semestre_asignatura AS asignatura_posterior_semestre, "
			+ "    p.nombre AS asignatura_posterior_nombre "
			+ " FROM res_asignatura_prerrequisito pr "
			+ " JOIN res_asignatura a ON pr.codigo_asignatura_anterior = a.codigo "
			+ " JOIN res_asignatura p ON pr.codigo_asignatura_posterior = p.codigo", nativeQuery = true)
	Page<Prerrequisito> findPrerrequisitosWithPaginationAndSorting(PageRequest pageRequest) throws Exception;
	
	
	@Query(value = "SELECT "
			+ "	   pr.id, "
			+ "	   a.codigo AS asignatura_anterior_codigo, "
			+ "    a.semestre_asignatura AS asignatura_anterior_semestre, "
			+ "    a.nombre AS asignatura_anterior_nombre, "
			+ "    p.codigo AS asignatura_posterior_codigo, "
			+ "    p.semestre_asignatura AS asignatura_posterior_semestre, "
			+ "    p.nombre AS asignatura_posterior_nombre "
			+ " FROM res_asignatura_prerrequisito pr "
			+ " JOIN res_asignatura a ON pr.codigo_asignatura_anterior = a.codigo "
			+ " JOIN res_asignatura p ON pr.codigo_asignatura_posterior = p.codigo"
			+ " WHERE p.codigo = :codigo", nativeQuery = true)
	Page<Prerrequisito> findAsignaturasAnterioresByCodigoAsignaturaWithPaginationAndSorting(@Param("codigo") Integer codigo, PageRequest pageRequest) throws Exception;
	
	
	@Query(value = "SELECT "
			+ "	   pr.id, "
			+ "	   a.codigo AS asignatura_anterior_codigo, "
			+ "    a.semestre_asignatura AS asignatura_anterior_semestre, "
			+ "    a.nombre AS asignatura_anterior_nombre, "
			+ "    p.codigo AS asignatura_posterior_codigo, "
			+ "    p.semestre_asignatura AS asignatura_posterior_semestre, "
			+ "    p.nombre AS asignatura_posterior_nombre "
			+ " FROM res_asignatura_prerrequisito pr "
			+ " JOIN res_asignatura a ON pr.codigo_asignatura_anterior = a.codigo "
			+ " JOIN res_asignatura p ON pr.codigo_asignatura_posterior = p.codigo"
			+ " WHERE a.codigo = :codigo", nativeQuery = true)
	Page<Prerrequisito> findAsignaturasPosterioresByCodigoAsignaturaWithPaginationAndSorting(@Param("codigo") Integer codigo, PageRequest pageRequest) throws Exception;

	
}
