package com.nttdata.msbanco.model.Service;

import com.nttdata.msbanco.model.Entity.BootCoinPurse;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootCoinPurseService {
    Mono<BootCoinPurse> saveCoinPurse(BootCoinPurse coinPurse);
    Mono<BootCoinPurse> updateCoinPurse(BootCoinPurse coinPurse);
    Mono<Void> deleteCoinPurse(ObjectId id);
    Flux<BootCoinPurse> getCoinPurseList();
    Mono<BootCoinPurse> getCoinPurse(String documentNumber);
}