package com.nttdata.msbanco.repository;

import com.nttdata.msbanco.model.Entity.BootCoin;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BootCoinRepository extends ReactiveCrudRepository<BootCoin, ObjectId> {}
