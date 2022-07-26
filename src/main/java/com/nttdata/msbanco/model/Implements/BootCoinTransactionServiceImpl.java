package com.nttdata.msbanco.model.Implements;

import com.nttdata.msbanco.model.Entity.BootCoinTransaction;
import com.nttdata.msbanco.model.Service.BootCoinTransactionService;
import com.nttdata.msbanco.repository.BootCoinTransactionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@Service
public class BootCoinTransactionServiceImpl implements BootCoinTransactionService {

    BootCoinTransactionRepository bootCoinTransactionRepository;


    @Override
    public Mono<BootCoinTransaction> saveTransaction(BootCoinTransaction transaction) {
        return bootCoinTransactionRepository.save(transaction);
    }

    @Override
    public Mono<BootCoinTransaction> updateTransaction(BootCoinTransaction transaction) {
        return bootCoinTransactionRepository.save(transaction);
    }

    @Override
    public Mono<Void> deleteTransaction(ObjectId id) {
        return bootCoinTransactionRepository.deleteById(id);
    }

    @Override
    public Flux<BootCoinTransaction> getTransactions() {
        return bootCoinTransactionRepository.findAll();
    }

    @Override
    public Mono<BootCoinTransaction> getTransaction(String cellphoneNumberBankAccountNumber) {
        return bootCoinTransactionRepository.findAll()
                .filter(transaction -> transaction.getCellphoneNumber().equals(cellphoneNumberBankAccountNumber) || transaction.getAccountNumber().equals(cellphoneNumberBankAccountNumber))
                .elementAt(0, new BootCoinTransaction(null, 0.0, "NO ENCONTRADO", "NO ENCONTRADO", "NO ENCONTRADO"));
    }
}