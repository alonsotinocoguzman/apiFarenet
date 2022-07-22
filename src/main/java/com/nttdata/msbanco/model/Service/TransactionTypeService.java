package com.nttdata.msbanco.model.Service;

import com.nttdata.msbanco.model.Entity.TransactionType;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionTypeService {
  Mono<TransactionType> saveTransactionType(TransactionType transactionType);

  Mono<TransactionType> updateTransactionType(TransactionType transactionType);

  Mono<Void> deleteTransactionType(ObjectId id);

  Flux<TransactionType> getTransactionTypeList();

  Mono<TransactionType> getTransactionType(String code);
}
