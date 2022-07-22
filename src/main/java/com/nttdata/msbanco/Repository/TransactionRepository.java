package com.nttdata.msbanco.Repository;

import com.nttdata.msbanco.Model.Entity.Transaction;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, ObjectId> {}
