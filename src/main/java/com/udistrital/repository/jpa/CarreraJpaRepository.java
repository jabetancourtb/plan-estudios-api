package com.udistrital.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.entity.Carrera;

public interface CarreraJpaRepository extends JpaRepository<Carrera, String> {
	
	@Query(value = "SELECT a.carrera FROM res_asignatura a WHERE carrera LIKE CONCAT('%', :nombre, '%') GROUP BY carrera", nativeQuery = true)
	Page<Carrera> findCarreraByNameAndWithPaginationAndSorting(@Param("nombre") String nombre, PageRequest pageRequest) throws Exception;
	
}
