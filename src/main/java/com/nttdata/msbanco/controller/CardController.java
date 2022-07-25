package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.kafka.producer.KafkaStringProducer;
import com.nttdata.msbanco.model.Entity.Card;
import com.nttdata.msbanco.model.Entity.Dto.CardDto;
import com.nttdata.msbanco.model.Service.CardService;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(UIUtils.BASEURL_CARD)
public class CardController {
  private final CardService cardService;
  private final KafkaStringProducer kafkaStringProducer;

  @PostMapping(UIUtils.CARD_CREATE)
  public Flux<Card> createCard(@RequestBody Card cardMono) {
    kafkaStringProducer.sendMessage("Ingreso al createCard: " + cardMono.toString());
    return cardService.createAccountInitial(cardMono);
  }

  @PostMapping(UIUtils.CARD_LOAD_BALANCE)
  public Mono<Card> loadBalance(
      @RequestParam Double loadBalance, @PathVariable(value = "id") String id) {
    kafkaStringProducer.sendMessage(
        "Ingreso al loadBalance: " + id + "la carga es de :" + loadBalance);
    return cardService.loadBalance(loadBalance, id);
  }

  @PostMapping(UIUtils.CARD_PAY_BALANCE)
  public Mono<Card> payBalance(
      @RequestParam Double loadBalance, @PathVariable(value = "id") String id) {
    kafkaStringProducer.sendMessage(
        "Ingreso al payBalance: " + id + " la carga es de: " + loadBalance);
    return cardService.payBalance(loadBalance, id);
  }

  @GetMapping(UIUtils.CARD_GET_BALANCE)
  public Mono<CardDto> getBalance(@PathVariable(value = "id") String id) {
    kafkaStringProducer.sendMessage("Ingreso al getBalance: " + id);
    return cardService.getBalance(id);
  }
}
