package com.udistrital.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.entity.CampoFormacion;


public interface CampoFormacionJpaRepository extends JpaRepository<CampoFormacion, Integer> {

	@Query(value = "SELECT cf.id, cf.nombre FROM campo_formacion cf WHERE cf.nombre LIKE CONCAT('%', :nombre, '%')", nativeQuery = true)
	Page<CampoFormacion> findCamposFormacionByNameAndWithPaginationAndSorting(@Param("nombre") String nombre, PageRequest pageRequest) throws Exception;
	
}
