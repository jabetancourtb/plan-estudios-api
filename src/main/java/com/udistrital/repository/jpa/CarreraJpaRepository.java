package com.udistrital.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.entity.Carrera;

public interface CarreraJpaRepository extends JpaRepository<Carrera, Integer> {
	
	@Query(value = "SELECT c.id, c.nombre FROM carrera c WHERE c.nombre LIKE CONCAT('%', :nombre, '%')", nativeQuery = true)
	Page<Carrera> findCarrerasByNameAndWithPaginationAndSorting(@Param("nombre") String nombre, PageRequest pageRequest) throws Exception;
	
}
