package com.udistrital.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.udistrital.entity.AreaFormacion;


public interface AreaFormacionJpaRepository extends JpaRepository<AreaFormacion, Integer> {
	
	@Query(value = " SELECT "
			+ "  af.id, "
			+ "  af.id_campo_formacion, "
			+ "  af.nombre, "
			+ "  af.color_html, "
			+ "  COUNT(ra.area_formacion) AS cantidad_asignaturas "
			+ " FROM area_formacion af "
			+ " LEFT JOIN ( "
			+ "  SELECT "
			+ "    CASE "
			+ "      WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Ciencias Básicas')) THEN 'Electiva Ciencias Básicas'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Socio humanística')) THEN 'Electiva Socio humanística'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Ingeniería Aplicada')) THEN 'Electiva Ingeniería Aplicada'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Económico Administrativa')) THEN 'Electiva Económico Administrativa'"
			+ "      WHEN area_formacion IS NULL OR area_formacion = '' THEN 'Otros'"
			+ "      ELSE area_formacion"
			+ "    END AS area_formacion"
			+ "  FROM res_asignatura"
			+ " ) ra ON ra.area_formacion = af.nombre"
			+ " GROUP BY af.id, af.nombre, af.color_html", 
			countQuery = "SELECT COUNT(*) FROM area_formacion",
			nativeQuery = true)
	Page<AreaFormacion> findAreasFormacionWithPaginationAndSorting(PageRequest pageRequest) throws Exception;
	
	
	@Query(value = " SELECT "
			+ "  af.id, "
			+ "  af.id_campo_formacion, "
			+ "  af.nombre, "
			+ "  af.color_html, "
			+ "  COUNT(ra.area_formacion) AS cantidad_asignaturas "
			+ " FROM area_formacion af "
			+ " LEFT JOIN ( "
			+ "  SELECT "
			+ "    CASE "
			+ "      WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Ciencias Básicas')) THEN 'Electiva Ciencias Básicas'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Socio humanística')) THEN 'Electiva Socio humanística'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Ingeniería Aplicada')) THEN 'Electiva Ingeniería Aplicada'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Económico Administrativa')) THEN 'Electiva Económico Administrativa'"
			+ "      WHEN area_formacion IS NULL OR area_formacion = '' THEN 'Otros'"
			+ "      ELSE area_formacion"
			+ "    END AS area_formacion"
			+ "  FROM res_asignatura"
			+ " ) ra ON ra.area_formacion = af.nombre"
			+ " WHERE af.id = :id"
			+ " GROUP BY af.id, af.nombre, af.color_html",
			nativeQuery = true)
	AreaFormacion findAreaFormacionById(@Param("id") Integer id) throws Exception;

	
	@Query(value = " SELECT "
			+ "  af.id, "
			+ "  af.id_campo_formacion, "
			+ "  af.nombre, "
			+ "  af.color_html, "
			+ "  COUNT(ra.area_formacion) AS cantidad_asignaturas "
			+ " FROM area_formacion af "
			+ " LEFT JOIN ( "
			+ "  SELECT "
			+ "    CASE "
			+ "      WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Ciencias Básicas')) THEN 'Electiva Ciencias Básicas'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Socio humanística')) THEN 'Electiva Socio humanística'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Ingeniería Aplicada')) THEN 'Electiva Ingeniería Aplicada'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Económico Administrativa')) THEN 'Electiva Económico Administrativa'"
			+ "      WHEN area_formacion IS NULL OR area_formacion = '' THEN 'Otros'"
			+ "      ELSE area_formacion"
			+ "    END AS area_formacion"
			+ "  FROM res_asignatura"
			+ " ) ra ON ra.area_formacion = af.nombre"
			+ " WHERE af.nombre LIKE CONCAT('%', :nombre, '%') "
			+ " GROUP BY af.id, af.nombre, af.color_html", 
			countQuery = "SELECT COUNT(*) FROM area_formacion",
			nativeQuery = true)
	Page<AreaFormacion> findAreasFormacionByNameAndWithPaginationAndSorting(@Param("nombre") String nombre, PageRequest pageRequest) throws Exception;
	
	
	@Query(value = " SELECT "
			+ "  af.id, "
			+ "  af.id_campo_formacion, "
			+ "  af.nombre, "
			+ "  af.color_html, "
			+ "  COUNT(ra.area_formacion) AS cantidad_asignaturas "
			+ " FROM area_formacion af "
			+ " LEFT JOIN ( "
			+ "  SELECT "
			+ "    CASE "
			+ "      WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Ciencias Básicas')) THEN 'Electiva Ciencias Básicas'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Socio humanística')) THEN 'Electiva Socio humanística'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Ingeniería Aplicada')) THEN 'Electiva Ingeniería Aplicada'"
			+ "	  WHEN ((area_formacion = 'Electivas') or (area_formacion = 'Electiva')) AND ((campo_formacion = 'Económico Administrativa')) THEN 'Electiva Económico Administrativa'"
			+ "      WHEN area_formacion IS NULL OR area_formacion = '' THEN 'Otros'"
			+ "      ELSE area_formacion"
			+ "    END AS area_formacion"
			+ "  FROM res_asignatura"
			+ " ) ra ON ra.area_formacion = af.nombre"
			+ " WHERE af.id_campo_formacion = :idCampoFormacion"
			+ " GROUP BY af.id, af.nombre, af.color_html", 
			countQuery = "SELECT COUNT(*) FROM area_formacion",
			nativeQuery = true)
	Page<AreaFormacion> findAreasFormacionByIdCampoFormacionAndWithPaginationAndSorting(@Param("idCampoFormacion") Integer idCampoFormacion, PageRequest pageRequest) throws Exception;
	
}
