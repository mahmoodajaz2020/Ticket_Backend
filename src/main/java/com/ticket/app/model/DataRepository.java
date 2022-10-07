package com.ticket.app.model;

import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Data, Integer> {
    
}