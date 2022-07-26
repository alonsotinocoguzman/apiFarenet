package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.model.Entity.BootCoin;
import com.nttdata.msbanco.model.Entity.Dto.BootCoinDto;
import com.nttdata.msbanco.model.Service.BootCoinService;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping(UIUtils.BOOT_COIN_BASE)
@AllArgsConstructor
@Slf4j
public class BootCoinController {
  private final BootCoinService bootCoinService;

  @PostMapping(UIUtils.BOOT_COIN_SAVE)
  public Mono<BootCoin> saveBootCoin(@RequestBody BootCoin bootCoin) {
    return bootCoinService.saveBootCoin(bootCoin);
  }

  @PostMapping(UIUtils.BOOT_COIN_APPROVE)
  public Mono<BootCoin> approveTransaction(
      @RequestParam("id") String id,
      @RequestParam("isAccepted") Boolean isAccepted,
      @RequestParam("bankFeeId") String bankFeeId) {
    return bootCoinService.acceptTransaction(id, isAccepted, bankFeeId);
  }

  @PostMapping(UIUtils.BOOT_COIN_TRACKING)
  public Mono<BootCoin> trackingTransaction(@RequestBody BootCoinDto bootCoinDto) throws IOException {
    return bootCoinService.validateTransaction(bootCoinDto);
  }
}
