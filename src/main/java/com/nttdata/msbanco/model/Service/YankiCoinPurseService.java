package com.nttdata.msbanco.model.Service;

import com.nttdata.msbanco.model.Entity.YankiCoinPurse;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface YankiCoinPurseService {
    Mono<YankiCoinPurse> saveYankiCoinPurse(YankiCoinPurse yankiCoinPurse);
    Mono<YankiCoinPurse> updateYankiCoinPurse(YankiCoinPurse yankiCoinPurse);
    Mono<Void> deleteYankiCoinPurse(ObjectId id);
    Flux<YankiCoinPurse> getAllYankiCoinPurses();
    Mono<YankiCoinPurse> getYankiCoinPurse(String documentNumber);
}