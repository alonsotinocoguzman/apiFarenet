package com.nttdata.msbanco.model.Service;

import com.nttdata.msbanco.model.Entity.BankFee;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankFeeService {
  Mono<BankFee> saveBankFee(BankFee bankFee);

  Mono<BankFee> updateBankFee(BankFee bankFee);

  Mono<Void> deleteBankFee(ObjectId id);

  Flux<BankFee> getAllBankFee();

  Mono<BankFee> getBankFee(String id);
}
