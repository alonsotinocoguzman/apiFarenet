package com.nttdata.msbanco.repository;

import com.nttdata.msbanco.model.Entity.Transaction;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, ObjectId> {}
