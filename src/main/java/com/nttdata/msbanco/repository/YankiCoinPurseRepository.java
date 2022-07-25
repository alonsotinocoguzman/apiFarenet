package com.nttdata.msbanco.repository;

import com.nttdata.msbanco.model.Entity.YankiCoinPurse;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface YankiCoinPurseRepository extends ReactiveCrudRepository<YankiCoinPurse, ObjectId> {
}