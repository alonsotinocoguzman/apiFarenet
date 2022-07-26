package com.nttdata.msbanco.model.Implements;

import com.nttdata.msbanco.model.Entity.BootCoinPurse;
import com.nttdata.msbanco.model.Entity.BootCoinTransaction;
import com.nttdata.msbanco.model.Entity.YankiCoinPurse;
import com.nttdata.msbanco.model.Service.BootCoinPurseService;
import com.nttdata.msbanco.model.Service.BootCoinTransactionService;
import com.nttdata.msbanco.model.Service.YankiCoinPurseService;
import com.nttdata.msbanco.repository.BootCoinTransactionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

@Slf4j
@AllArgsConstructor
@Service
public class BootCoinTransactionServiceImpl implements BootCoinTransactionService {

    BootCoinTransactionRepository bootCoinTransactionRepository;
    BootCoinPurseService bootCoinPurseService;
    YankiCoinPurseService yankiCoinPurseService;


    @Override
    public Mono<BootCoinTransaction> saveTransaction(BootCoinTransaction transaction) {
        Random random = new Random();
        Integer upperbound = 999999999;
        Integer randomNumber = random.nextInt(upperbound);

        transaction.setTransactionNumber(randomNumber);

        Mono<BootCoinPurse> bootCoinPurse = bootCoinPurseService.getCoinPurse(transaction.getCellphoneNumber());
        bootCoinPurse.subscribe(cp -> {
            Double availableBalance = cp.getAvailableBalance();
            availableBalance = availableBalance + (transaction.getAmount() / 2);
            log.info("BootCoin availableBalance: " + availableBalance);
            cp.setAvailableBalance(availableBalance);

            bootCoinPurseService.updateCoinPurse(cp).subscribe();
        });

        Mono<YankiCoinPurse> yankiCoinPurse = yankiCoinPurseService.getYankiCoinPurse(transaction.getCellphoneNumber());
        yankiCoinPurse.subscribe(ycp->{
            Double balance = ycp.getAvailableBalance();
            balance = balance - transaction.getAmount();
            log.info("Yanki availableBalance: " + balance);

            ycp.setAvailableBalance(balance);
            yankiCoinPurseService.updateYankiCoinPurse(ycp).subscribe();
        });

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
                .elementAt(0, new BootCoinTransaction(null, 0, 0.0, "NO ENCONTRADO", "NO ENCONTRADO", "NO ENCONTRADO"));
    }
}