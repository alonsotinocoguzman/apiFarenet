package com.nttdata.msbanco.Model.Service;

import com.nttdata.msbanco.Model.Entity.BankAccount;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface BankAccountService {
    Mono<BankAccount> saveBankAccount(BankAccount bankAccount)throws Exception;
    Mono<BankAccount> updateBankAccount(BankAccount bankAccount);
    Mono<Void> deleteBankAccount(ObjectId bankAccountId);
    Flux<BankAccount> getAllBankAccountsByCustomer(String documentNumber);
    Mono<BankAccount> getBankAccount(ObjectId bankAccountId);
}