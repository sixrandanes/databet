package com.databet.ref.competitions;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetitionRepository extends MongoRepository<Competition, Integer> {

    Competition findByName(String name);
    
    List<Competition> findByNameIn(List<String> competitions);
}