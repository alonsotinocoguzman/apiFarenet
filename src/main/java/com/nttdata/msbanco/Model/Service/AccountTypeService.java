package com.nttdata.msbanco.Model.Service;

import com.nttdata.msbanco.Model.Entity.AccountType;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountTypeService {
  Flux<AccountType> findAll();

  Mono<AccountType> findById(Integer idAccountType);

  Flux<AccountType> saveAccountType(Flux<AccountType> accountType);

  Mono<AccountType> updateAccountType(AccountType accountType);

  Mono<Void> deleteAccountType(ObjectId idAccountType);
}
