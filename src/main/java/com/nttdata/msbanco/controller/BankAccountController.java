package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.model.Entity.BankAccount;
import com.nttdata.msbanco.model.Service.BankAccountService;
import com.nttdata.msbanco.model.Service.CustomerService;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(UIUtils.BANKACCOUNT_BASEURL)
public class BankAccountController {
  private final BankAccountService bankAccountService;
  private final CustomerService customerService;

  @PostMapping(UIUtils.BANKACCOUNT_INS)
  public Mono<BankAccount> saveBankAccount(@RequestBody BankAccount bankAccount) throws Exception {
    log.info("INICIO saveBankAccount");
    Mono<BankAccount> bankAccountMono = bankAccountService.saveBankAccount(bankAccount);
    /*bankAccountMono.subscribe(ba -> {
        log.info("FIN saveBankAccount");
        log.info("Cuenta Bancaria Registrada:");
        log.info(ba.getDocumentNumber());
        log.info(ba.getNumberAccount());
        log.info(ba.getAccountBalance().toString());
    });*/
    /*BankAccount ba = bankAccountMono.block();
    log.info("FIN saveBankAccount");
    log.info("Cuenta Bancaria Registrada:");
    log.info(ba.getDocumentNumber());
    log.info(ba.getNumberAccount());
    log.info(ba.getAccountBalance().toString());*/

    return bankAccountMono;
  }

  @PutMapping(UIUtils.BANKACCOUNT_UPD)
  public Mono<BankAccount> updateBankAccount(@RequestBody BankAccount bankAccount) {
    return bankAccountService.updateBankAccount(bankAccount);
  }

  @DeleteMapping(UIUtils.BANKACCOUNT_DEL)
  public Mono<Void> deleteBankAccount(
      @PathVariable(value = "bankAccountId") ObjectId bankAccountId) {
    return bankAccountService.deleteBankAccount(bankAccountId);
  }

  @GetMapping(UIUtils.BANKACCOUNT_ALL_BY_CUSTOMER)
  public Flux<BankAccount> getAllBankAccountsByCustomer(
      @PathVariable(value = "documentNumber") String documentNumber) {
    return bankAccountService.getAllBankAccountsByCustomer(documentNumber);
  }

  @GetMapping(UIUtils.BANKACCOUNT_ID)
  public Mono<BankAccount> getBankAccount(
      @PathVariable(value = "bankAccountId") ObjectId bankAccountId) {
    return bankAccountService.getBankAccount(bankAccountId);
  }
}
