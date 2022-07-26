package com.nttdata.msbanco.repository;

import com.nttdata.msbanco.model.Entity.BootCoinPurse;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BootCoinPurseRepository extends ReactiveCrudRepository<BootCoinPurse, ObjectId> {
}