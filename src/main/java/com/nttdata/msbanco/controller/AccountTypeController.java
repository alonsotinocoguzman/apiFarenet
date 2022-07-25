package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.kafka.producer.KafkaStringProducer;
import com.nttdata.msbanco.model.Entity.AccountType;
import com.nttdata.msbanco.model.Service.AccountTypeService;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(UIUtils.BASEURLACCOUNTTYPE)
@Slf4j
@AllArgsConstructor
public class AccountTypeController {
  private final AccountTypeService accountTypeService;
  private final KafkaStringProducer kafkaStringProducer;

  @GetMapping(UIUtils.ACCOUNT_TYPE_ALL)
  public Flux<AccountType> getAllAccountType() {
    log.info("Ingreso a getAllAccountType");
    kafkaStringProducer.sendMessage("Ingreso a getAllAccountType");
    return accountTypeService.findAll();
  }

  @GetMapping(UIUtils.ACCOUNT_TYPE_ID)
  public Mono<AccountType> getAccountTypeById(
      @PathVariable(value = "idAccountType") Integer idAccountType) {
    log.info("Ingreso a getAccountTypeById");
    kafkaStringProducer.sendMessage("Ingreso a getAccountTypeById: " + idAccountType);
    return accountTypeService.findById(idAccountType);
  }

  @PostMapping(UIUtils.ACCOUNT_TYPE_INS)
  public Flux<AccountType> saveAccountType(@RequestBody Flux<AccountType> AccountType) {
    log.info("Ingreso a saveAccountType");
    kafkaStringProducer.sendMessage("Ingreso a saveAccountType " + AccountType.log());
    return accountTypeService.saveAccountType(AccountType);
  }

  @PutMapping(UIUtils.ACCOUNT_TYPE_UPD)
  public Mono<AccountType> updateAccountType(@RequestBody AccountType AccountType) {
    log.info("Ingreso a updateAccountType");
    kafkaStringProducer.sendMessage("Ingreso a updateAccountType: " + AccountType.toString());
    return accountTypeService.updateAccountType(AccountType);
  }

  @DeleteMapping(UIUtils.ACCOUNT_TYPE_DEL)
  public Mono<Void> deleteAccountType(@PathVariable(value = "id") ObjectId idAccountType) {
    log.info("Ingreso a deleteAccountType");
    kafkaStringProducer.sendMessage("Ingreso a deleteAccountType: " + idAccountType);
    return accountTypeService.deleteAccountType(idAccountType);
  }
}
