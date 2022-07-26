package com.nttdata.msbanco.model.Implements;

import com.nttdata.msbanco.model.Entity.BootCoinExchangeRate;
import com.nttdata.msbanco.model.Service.BootCoinExchangeRateService;
import com.nttdata.msbanco.repository.BootCoinExchangeRateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@Service
public class BootCoinExchangeRateServiceImpl implements BootCoinExchangeRateService {

    BootCoinExchangeRateRepository bootCoinExchangeRateRepository;

    @Override
    public Mono<BootCoinExchangeRate> saveExchangeRate(BootCoinExchangeRate exchangeRate) {
        return bootCoinExchangeRateRepository.save(exchangeRate);
    }

    @Override
    public Mono<BootCoinExchangeRate> updateExchangeRate(BootCoinExchangeRate exchangeRate) {
        return bootCoinExchangeRateRepository.save(exchangeRate);
    }

    @Override
    public Mono<Void> deleteExchangeRate(ObjectId id) {
        return bootCoinExchangeRateRepository.deleteById(id);
    }

    @Override
    public Flux<BootCoinExchangeRate> getExchangeRateList() {
        return bootCoinExchangeRateRepository.findAll();
    }

    @Override
    public Mono<BootCoinExchangeRate> getExchangeRate(String currency) {
        return bootCoinExchangeRateRepository.findAll()
                .filter(exchangeRate -> exchangeRate.getCurrency().equals(currency))
                .elementAt(0, new BootCoinExchangeRate(null, 0.0, 0.0, "NO ENCONTRADO"));
    }
}