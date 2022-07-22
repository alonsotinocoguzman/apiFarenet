package com.nttdata.msbanco.model.Implements;

import com.nttdata.msbanco.model.Entity.AccountType;
import com.nttdata.msbanco.model.Service.AccountTypeService;
import com.nttdata.msbanco.model.Service.ProductBankService;
import com.nttdata.msbanco.repository.AccountTypeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class AccountTypeImpl implements AccountTypeService {
  private final AccountTypeRepository accountTypeRepository;
  private final ProductBankService productBankService;

  @Override
  public Flux<AccountType> findAll() {
    return accountTypeRepository.findAll();
  }

  @Override
  public Mono<AccountType> findById(Integer idAccountType) {
    return accountTypeRepository
        .findAll()
        .filter(x -> x.getIdAccountType().equals(idAccountType))
        .elementAt(0);
  }

  @Override
  public Flux<AccountType> saveAccountType(Flux<AccountType> accountType) {
    return accountTypeRepository.saveAll(accountType);
  }

  @Override
  public Mono<AccountType> updateAccountType(AccountType accountType) {
    return accountTypeRepository.save(accountType);
  }

  @Override
  public Mono<Void> deleteAccountType(ObjectId idAccountType) {
    return accountTypeRepository.deleteById(idAccountType);
  }
}
