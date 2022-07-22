package com.nttdata.msbanco.model.Implements;

import com.nttdata.msbanco.model.Entity.TransactionType;
import com.nttdata.msbanco.model.Service.TransactionTypeService;
import com.nttdata.msbanco.repository.TransactionTypeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {
  private TransactionTypeRepository transactionTypeRepository;

  @Override
  public Mono<TransactionType> saveTransactionType(TransactionType transactionType) {
    return transactionTypeRepository.save(transactionType);
  }

  @Override
  public Mono<TransactionType> updateTransactionType(TransactionType transactionType) {
    return transactionTypeRepository.save(transactionType);
  }

  @Override
  public Mono<Void> deleteTransactionType(ObjectId id) {
    return transactionTypeRepository.deleteById(id);
  }

  @Override
  public Flux<TransactionType> getTransactionTypeList() {
    return transactionTypeRepository.findAll();
  }

  @Override
  public Mono<TransactionType> getTransactionType(String code) {
    return transactionTypeRepository
        .findAll()
        .filter(transactionType -> transactionType.getCode().equals(code))
        .elementAt(0);
  }
}
