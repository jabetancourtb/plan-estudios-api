package com.udistrital.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.entity.Prerrequisito;

public interface PrerrequisitoJpaRepository extends JpaRepository<Prerrequisito, Integer> {

	@Query(value = "SELECT "
			+ "	   r.id, "
			+ "	   p.codigo AS prerrequisito_codigo, "
			+ "    p.semestre_asignatura AS prerrequisito_semestre, "
			+ "    p.nombre AS prerrequisito, "
			+ "    a.codigo AS asignatura_codigo, "
			+ "    a.semestre_asignatura AS asignatura_semestre, "
			+ "    a.nombre AS asignatura "
			+ " FROM res_asignatura_prerrequisito r "
			+ " JOIN res_asignatura a ON r.asignatura_codigo = a.codigo "
			+ " JOIN res_asignatura p ON r.prerrequisito_codigo = p.codigo", nativeQuery = true)
	Page<Prerrequisito> findAsignaturasPrerrequisitosWithPaginationAndSorting(PageRequest pageRequest) throws Exception;
	
	
	@Query(value = "SELECT "
			+ "	   r.id, "
			+ "	   p.codigo AS prerrequisito_codigo, "
			+ "    p.semestre_asignatura AS prerrequisito_semestre, "
			+ "    p.nombre AS prerrequisito, "
			+ "    a.codigo AS asignatura_codigo, "
			+ "    a.semestre_asignatura AS asignatura_semestre, "
			+ "    a.nombre AS asignatura "
			+ " FROM res_asignatura_prerrequisito r "
			+ " JOIN res_asignatura a ON r.asignatura_codigo = a.codigo "
			+ " JOIN res_asignatura p ON r.prerrequisito_codigo = p.codigo"
			+ " WHERE p.codigo = :codigoPrerrequisito", nativeQuery = true)
	Page<Prerrequisito> findPrerrequisitosByCodigoPrerrequisitoWithPaginationAndSorting(@Param("codigoPrerrequisito") Integer codigoPrerrequisito, PageRequest pageRequest) throws Exception;
	
	
	@Query(value = "SELECT "
			+ "	   r.id, "
			+ "	   p.codigo AS prerrequisito_codigo, "
			+ "    p.semestre_asignatura AS prerrequisito_semestre, "
			+ "    p.nombre AS prerrequisito, "
			+ "    a.codigo AS asignatura_codigo, "
			+ "    a.semestre_asignatura AS asignatura_semestre, "
			+ "    a.nombre AS asignatura "
			+ " FROM res_asignatura_prerrequisito r "
			+ " JOIN res_asignatura a ON r.asignatura_codigo = a.codigo "
			+ " JOIN res_asignatura p ON r.prerrequisito_codigo = p.codigo"
			+ " WHERE a.codigo = :codigoAsignatura", nativeQuery = true)
	Page<Prerrequisito> findPrerrequisitosByCodigoAsignaturaWithPaginationAndSorting(@Param("codigoAsignatura") Integer codigoAsignatura, PageRequest pageRequest) throws Exception;
	
	
}
