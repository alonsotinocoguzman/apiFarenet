package com.nttdata.msbanco.repository;

import com.nttdata.msbanco.model.Entity.BootCoinExchangeRate;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootCoinExchangeRateRepository extends ReactiveCrudRepository<BootCoinExchangeRate, ObjectId> {
}