package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.model.Entity.BootCoinExchangeRate;
import com.nttdata.msbanco.model.Service.BootCoinExchangeRateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("bootcoin-exchange-rate")
public class BootCoinExchangeRateController {

    private BootCoinExchangeRateService bootCoinExchangeRateService;

    @PostMapping("save")
    public Mono<BootCoinExchangeRate> saveExchangeRate(@RequestBody BootCoinExchangeRate exchangeRate) {
        return bootCoinExchangeRateService.saveExchangeRate(exchangeRate);
    }

    @PutMapping("update")
    public Mono<BootCoinExchangeRate> updateExchangeRate(@RequestBody BootCoinExchangeRate exchangeRate) {
        return bootCoinExchangeRateService.updateExchangeRate(exchangeRate);
    }

    @DeleteMapping("delete/{exchangeRateId}")
    public Mono<Void> deleteExchangeRate(@PathVariable(value = "exchangeRateId") ObjectId id) {
        return bootCoinExchangeRateService.deleteExchangeRate(id);
    }

    @GetMapping("find-all")
    public Flux<BootCoinExchangeRate> getExchangeRateList() {
        return bootCoinExchangeRateService.getExchangeRateList();
    }

    @GetMapping("find-id/{currency}")
    public Mono<BootCoinExchangeRate> getExchangeRate(@PathVariable(value = "currency") String currency) {
        return bootCoinExchangeRateService.getExchangeRate(currency);
    }
}