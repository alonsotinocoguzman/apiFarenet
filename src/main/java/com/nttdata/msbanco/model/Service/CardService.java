package com.nttdata.msbanco.model.Service;

import com.nttdata.msbanco.model.Entity.Card;
import com.nttdata.msbanco.model.Entity.Dto.CardDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {
  Mono<Card> loadBalance(Double loadBalance, String id);

  Flux<Card> createAccountInitial(Card car);

  Mono<Card> payBalance(Double payBalance, String id);

  Mono<CardDto> getBalance(String id);

  Flux<CardDto> getBalanceByCustomerId(String id);
}
