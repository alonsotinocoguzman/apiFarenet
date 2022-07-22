package com.nttdata.msbanco.Controller;

import com.nttdata.msbanco.Model.Entity.Card;
import com.nttdata.msbanco.Model.Entity.Dto.CardDto;
import com.nttdata.msbanco.Model.Service.CardService;
import com.nttdata.msbanco.Utils.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(UIUtils.BASEURL_CARD)
public class CardController {
  private final CardService cardService;

  @PostMapping(UIUtils.CARD_CREATE)
  public Flux<Card> createCard(@RequestBody Card cardMono) {
    return cardService.createAccountInitial(cardMono);
  }

  @PostMapping(UIUtils.CARD_LOAD_BALANCE)
  public Mono<Card> loadBalance(
      @RequestParam Double loadBalance, @PathVariable(value = "id") String id) {
    return cardService.loadBalance(loadBalance, id);
  }

  @PostMapping(UIUtils.CARD_PAY_BALANCE)
  public Mono<Card> payBalance(
      @RequestParam Double loadBalance, @PathVariable(value = "id") String id) {
    return cardService.payBalance(loadBalance, id);
  }

  @GetMapping(UIUtils.CARD_GET_BALANCE)
  public Mono<CardDto> getBalance(@PathVariable(value = "id") String id) {
    return cardService.getBalance(id);
  }
}
