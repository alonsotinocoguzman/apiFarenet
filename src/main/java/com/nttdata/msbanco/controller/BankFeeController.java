package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.model.Entity.BankFee;
import com.nttdata.msbanco.model.Service.BankFeeService;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(UIUtils.BANK_FEE_BASE)
@AllArgsConstructor
@Slf4j
public class BankFeeController {
  private final BankFeeService bankFeeService;

  @PostMapping(UIUtils.BANK_FEE_INS)
  public Mono<BankFee> saveBankFee(@RequestBody BankFee bankFee) {
    return bankFeeService.saveBankFee(bankFee);
  }

  @GetMapping("find")
  public Mono<BankFee> getBankFeeById(@RequestParam("id") String id) {
    return bankFeeService.getBankFee(id);
  }
}
