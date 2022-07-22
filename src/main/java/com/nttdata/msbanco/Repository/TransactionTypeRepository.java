package com.nttdata.msbanco.Repository;

import com.nttdata.msbanco.Model.Entity.TransactionType;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository
    extends ReactiveCrudRepository<TransactionType, ObjectId> {}
