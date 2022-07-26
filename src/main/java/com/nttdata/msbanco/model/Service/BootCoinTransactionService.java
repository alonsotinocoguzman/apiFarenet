package com.nttdata.msbanco.model.Service;

import com.nttdata.msbanco.model.Entity.BootCoinTransaction;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootCoinTransactionService {
    Mono<BootCoinTransaction> saveTransaction(BootCoinTransaction transaction);
    Mono<BootCoinTransaction> updateTransaction(BootCoinTransaction transaction);
    Mono<Void> deleteTransaction(ObjectId id);
    Flux<BootCoinTransaction> getTransactions();
    Mono<BootCoinTransaction> getTransaction(String cellphoneNumberBankAccountNumber);
}