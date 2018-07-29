package com.databet.ref.areas.teams;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, Integer> {

    public Team findByName(String name);
}