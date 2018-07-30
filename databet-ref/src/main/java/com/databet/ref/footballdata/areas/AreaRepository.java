package com.databet.ref.footballdata.areas;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AreaRepository extends MongoRepository<Area, Integer> {

    public Area findByName(String name);
}