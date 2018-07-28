package com.databet.ref.areas;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AreaRepository extends MongoRepository<Area, Integer> {

    public Area findByName(String name);
}