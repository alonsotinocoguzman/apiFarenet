package com.nttdata.msbanco.model.Service;

import com.nttdata.msbanco.model.Entity.BootCoinExchangeRate;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootCoinExchangeRateService {
    Mono<BootCoinExchangeRate> saveExchangeRate(BootCoinExchangeRate exchangeRate);
    Mono<BootCoinExchangeRate> updateExchangeRate(BootCoinExchangeRate exchangeRate);
    Mono<Void> deleteExchangeRate(ObjectId id);
    Flux<BootCoinExchangeRate> getExchangeRateList();
    Mono<BootCoinExchangeRate> getExchangeRate(String currency);
}