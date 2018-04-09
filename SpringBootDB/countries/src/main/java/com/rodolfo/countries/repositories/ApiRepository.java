package com.rodolfo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rodolfo.countries.models.Country;

public interface ApiRepository extends CrudRepository<Country, Long> {
	
	@Query(value="select c.name, l.percentage from world.countries c inner join world.languages l on c.id = l.country_id where l.language = 'Slovene' order by l.percentage DESC", nativeQuery = true)
	List<Object[]> query1();
	
	@Query(value="select c.name, count(l.country_id) as total from world.countries c inner join world.cities l on c.id = l.country_id group by l.country_id order by total DESC", nativeQuery = true)
	List<Object[]> query2();
	
	@Query(value="select l.name , l.population from world.countries c inner join world.cities l on c.id = l.country_id where c.name = 'Mexico' and l.population > 500000   order by l.population DESC", nativeQuery = true)
	List<Object[]> query3();

	@Query(value="select c.name, l.language,  l.percentage from world.countries c inner join world.languages l on c.id = l.country_id where l.percentage > 89 order by l.percentage DESC", nativeQuery = true)
	List<Object[]> query4();
	
	@Query(value="select name, surface_area, population from world.countries where surface_area < 501 and population > 100000", nativeQuery = true)
	List<Object[]> query5();
	
	@Query(value="select name, surface_area, population from world.countries where surface_area > 200 and government_form ='Constitutional Monarchy' and life_expectancy > 75", nativeQuery = true)
	List<Object[]> query6();
	
	@Query(value="Select l.name, l.district, l.population from world.countries c inner join world.cities l on c.id = l.country_id where c.name = 'Argentina'  and l.district = 'Buenos Aires' and l.population > 500000", nativeQuery = true)
	List<Object[]> query7();
	
	@Query(value="Select count(id) as total, region from world.countries group by region order by total desc", nativeQuery = true)
	List<Object[]> query8();
	
	

}
