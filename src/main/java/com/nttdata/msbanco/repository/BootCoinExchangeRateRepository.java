package com.nttdata.msbanco.repository;

import com.nttdata.msbanco.model.Entity.BootCoinExchangeRate;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BootCoinExchangeRateRepository extends ReactiveCrudRepository<BootCoinExchangeRate, ObjectId> {
}