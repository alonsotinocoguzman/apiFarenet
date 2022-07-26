package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.model.Entity.BootCoinPurse;
import com.nttdata.msbanco.model.Entity.BootCoinTransaction;
import com.nttdata.msbanco.model.Service.BootCoinTransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("bootcoin-transaction")
public class BootCoinTransactionController {

    BootCoinTransactionService bootCoinTransactionService;

    @PostMapping("save")
    public Mono<BootCoinTransaction> saveTransaction(@RequestBody BootCoinTransaction transaction) {
        return bootCoinTransactionService.saveTransaction(transaction);
    }

    @PutMapping("update")
    public Mono<BootCoinTransaction> updateTransaction(@RequestBody BootCoinTransaction transaction) {
        return bootCoinTransactionService.updateTransaction(transaction);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteTransaction(@PathVariable(value = "id") ObjectId id) {
        return bootCoinTransactionService.deleteTransaction(id);
    }

    @GetMapping("find-all")
    public Flux<BootCoinTransaction> getTransactionList() {
        return bootCoinTransactionService.getTransactions();
    }

    @GetMapping("find-id/{cellphone-account}")
    public Mono<BootCoinTransaction> getTransaction(@PathVariable(value = "cellphone-account") String cellphoneAccount) {
        return bootCoinTransactionService.getTransaction(cellphoneAccount);
    }
}