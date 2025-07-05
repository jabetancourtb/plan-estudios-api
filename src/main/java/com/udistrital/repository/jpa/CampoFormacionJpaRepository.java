package com.udistrital.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.entity.CampoFormacion;


public interface CampoFormacionJpaRepository extends JpaRepository<CampoFormacion, Integer> {
	
	@Query(value = "SELECT "
			+ "  cf.id, "
			+ "  cf.nombre, "
			+ "  cf.color_html, "
			+ "  COUNT(ra.campo_formacion) AS cantidad_asignaturas, "
			+ "  ("
			+ "    SELECT COUNT(*)  "
			+ "    FROM area_formacion af "
			+ "    WHERE af.id_campo_formacion = cf.id "
			+ "  ) AS cantidad_areas_formacion "
			+ " FROM campo_formacion cf "
			+ " LEFT JOIN (\r\n"
			+ "  SELECT "
			+ "    CASE "
			+ "      WHEN campo_formacion IS NULL OR campo_formacion = '' THEN 'Otros' "
			+ "      ELSE campo_formacion "
			+ "    END AS campo_formacion "
			+ "  FROM res_asignatura\r\n"
			+ " ) ra ON ra.campo_formacion = cf.nombre "
			+ " GROUP BY cf.id, cf.nombre, cf.color_html", 
			countQuery = "SELECT COUNT(*) FROM campo_formacion",
			nativeQuery = true)
	Page<CampoFormacion> findCamposFormacionWithPaginationAndSorting(Pageable pageable) throws Exception;
	
	
	@Query(value = "SELECT "
			+ "  cf.id, "
			+ "  cf.nombre, "
			+ "  cf.color_html, "
			+ "  COUNT(ra.campo_formacion) AS cantidad_asignaturas, "
			+ "  ("
			+ "    SELECT COUNT(*)  "
			+ "    FROM area_formacion af "
			+ "    WHERE af.id_campo_formacion = cf.id "
			+ "  ) AS cantidad_areas_formacion "
			+ " FROM campo_formacion cf "
			+ " LEFT JOIN (\r\n"
			+ "  SELECT "
			+ "    CASE "
			+ "      WHEN campo_formacion IS NULL OR campo_formacion = '' THEN 'Otros' "
			+ "      ELSE campo_formacion "
			+ "    END AS campo_formacion "
			+ "  FROM res_asignatura\r\n"
			+ " ) ra ON ra.campo_formacion = cf.nombre "
			+ " WHERE cf.id = :id "
			+ " GROUP BY cf.id, cf.nombre, cf.color_html", 
			nativeQuery = true)
	CampoFormacion findCampoFormacionById(@Param("id") Integer id) throws Exception;
	
	
	@Query(value = "SELECT "
			+ "  cf.id, "
			+ "  cf.nombre, "
			+ "  cf.color_html, "
			+ "  COUNT(ra.campo_formacion) AS cantidad_asignaturas, "
			+ "  ("
			+ "    SELECT COUNT(*)  "
			+ "    FROM area_formacion af "
			+ "    WHERE af.id_campo_formacion = cf.id "
			+ "  ) AS cantidad_areas_formacion "
			+ " FROM campo_formacion cf "
			+ " LEFT JOIN (\r\n"
			+ "  SELECT "
			+ "    CASE "
			+ "      WHEN campo_formacion IS NULL OR campo_formacion = '' THEN 'Otros' "
			+ "      ELSE campo_formacion "
			+ "    END AS campo_formacion "
			+ "  FROM res_asignatura\r\n"
			+ " ) ra ON ra.campo_formacion = cf.nombre "
			+ " WHERE cf.nombre LIKE CONCAT('%', :nombre, '%') "
			+ " GROUP BY cf.id, cf.nombre, cf.color_html", 
			countQuery = "SELECT COUNT(*) FROM campo_formacion",
			nativeQuery = true)
	Page<CampoFormacion> findCamposFormacionByNameAndWithPaginationAndSorting(@Param("nombre") String nombre, PageRequest pageRequest) throws Exception;
	
}
