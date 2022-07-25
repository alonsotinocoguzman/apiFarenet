package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.model.Entity.TransactionType;
import com.nttdata.msbanco.model.Service.TransactionTypeService;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(UIUtils.TRANSACTION_TYPE_BASEURL)
public class TransactionTypeController {
    private TransactionTypeService transactionTypeService;

    @PostMapping(UIUtils.TRANSACTION_TYPE_INS)
    public Mono<TransactionType> saveTransactionType(@RequestBody TransactionType transactionType) {
        return transactionTypeService.saveTransactionType(transactionType);
    }

    @PutMapping(UIUtils.TRANSACTION_TYPE_UPD)
    public Mono<TransactionType> updateTransaction(@RequestBody TransactionType transactionType) {
        return transactionTypeService.updateTransactionType(transactionType);
    }

    @DeleteMapping(UIUtils.TRANSACTION_TYPE_DEL)
    public Mono<Void> deleteTransactionType(@PathVariable(value = "transactionTypeId") ObjectId id) {
        return transactionTypeService.deleteTransactionType(id);
    }

    @GetMapping(UIUtils.TRANSACTION_TYPE_ALL)
    public Flux<TransactionType> getTransactionTypeList() {
        return transactionTypeService.getTransactionTypeList();
    }

    @GetMapping(UIUtils.TRANSACTION_TYPE_ID)
    public Mono<TransactionType> getTransactionType(
            @PathVariable(value = "transactionTypeCode") String code) {
        return transactionTypeService.getTransactionType(code);
    }
}
