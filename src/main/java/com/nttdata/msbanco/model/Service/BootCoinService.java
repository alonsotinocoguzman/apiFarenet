package com.nttdata.msbanco.model.Service;

import com.nttdata.msbanco.model.Entity.BootCoin;
import com.nttdata.msbanco.model.Entity.Dto.BootCoinDto;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface BootCoinService {
  Mono<BootCoin> saveBootCoin(BootCoin bootCoin);

  Mono<BootCoin> updateBootCoin(BootCoin bootCoin);

  Mono<Void> deleteBootCoin(ObjectId id);

  Flux<BootCoin> getAllBootCoin();

  Mono<BootCoin> getBootCoin(String id);

  Mono<BootCoin> acceptTransaction(String id, Boolean isAccepted, String bankFeeId);

  Mono<BootCoin> validateTransaction(BootCoinDto bootCoinDto)throws IOException;
}
