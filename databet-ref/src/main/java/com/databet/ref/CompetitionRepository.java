package com.databet.ref;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetitionRepository extends MongoRepository<Competition, Integer> {

    public Competition findByName(String name);
}