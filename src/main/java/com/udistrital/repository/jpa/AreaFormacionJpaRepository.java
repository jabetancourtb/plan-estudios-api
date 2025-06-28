package com.udistrital.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.entity.AreaFormacion;


public interface AreaFormacionJpaRepository extends JpaRepository<AreaFormacion, Integer> {

	@Query(value = "SELECT af.id, af.nombre FROM area_formacion af WHERE af.nombre LIKE CONCAT('%', :nombre, '%')", nativeQuery = true)
	Page<AreaFormacion> findAreasFormacionByNameAndWithPaginationAndSorting(@Param("nombre") String nombre, PageRequest pageRequest) throws Exception;
	
}
