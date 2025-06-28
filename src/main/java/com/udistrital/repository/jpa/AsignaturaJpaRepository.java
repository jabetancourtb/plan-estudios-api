package com.udistrital.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.entity.Asignatura;


public interface AsignaturaJpaRepository extends JpaRepository<Asignatura, Integer> {
	
	@Query(value = "SELECT a.* FROM res_asignatura a WHERE a.carrera = :carrera", nativeQuery = true)
	Page<Asignatura> findAsignaturasByCarreraAndWithPaginationAndSorting(@Param("carrera") String carrera, PageRequest pageRequest) throws Exception;
	
	@Query(value = "SELECT a.* FROM res_asignatura a WHERE a.campo_formacion = :campoFormacion", nativeQuery = true)
	Page<Asignatura> findAsignaturasByCampoFormacionAndWithPaginationAndSorting(@Param("campoFormacion") String campoFormacion, PageRequest pageRequest) throws Exception;
	
	@Query(value = "SELECT a.* FROM res_asignatura a WHERE a.area_formacion = :areaFormacion", nativeQuery = true)
	Page<Asignatura> findAsignaturasByAreaFormacionAndWithPaginationAndSorting(@Param("areaFormacion") String areaFormacion, PageRequest pageRequest) throws Exception;
	
	@Query(value = "SELECT a.* FROM res_asignatura a WHERE a.semestre_asignatura = :semestre", nativeQuery = true)
	Page<Asignatura> findAsignaturasBySemestreAndWithPaginationAndSorting(@Param("semestre") Integer semestre, PageRequest pageRequest) throws Exception;
	
		
	@Query(value = "SELECT a.semestre_asignatura AS semestre FROM res_asignatura a GROUP BY a.semestre_asignatura", nativeQuery = true)
	Page<Integer> findSemestresWithPaginationAndSorting(PageRequest pageRequest) throws Exception;

}
