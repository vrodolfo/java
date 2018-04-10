package com.rodolfo.dojos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rodolfo.dojos.models.Ninja;

@Repository
public interface NinjaRepository  extends PagingAndSortingRepository<Ninja, Long> {

}
