package com.rodolfo.beltreviewerevents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rodolfo.beltreviewerevents.models.Message;

@Repository
public interface MessageRepository  extends CrudRepository<Message, Long> {

}
