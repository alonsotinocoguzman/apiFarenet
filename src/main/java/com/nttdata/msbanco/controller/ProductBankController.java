package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.kafka.producer.KafkaStringProducer;
import com.nttdata.msbanco.model.Entity.ProductBank;
import com.nttdata.msbanco.model.Service.ProductBankService;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(UIUtils.BANKPRODUCT_BASEURL)
@Slf4j
@AllArgsConstructor
public class ProductBankController {
  private final ProductBankService bankProductService;
  private final KafkaStringProducer kafkaStringProducer;

  @PostMapping(UIUtils.BANKPRODUCT_INS)
  public Flux<ProductBank> saveBankProducts(@RequestBody List<ProductBank> bankProducts) {
    log.info("Ingreso a saveBankProducts");
    kafkaStringProducer.sendMessage("Ingreso a saveBankProducts");
    return bankProductService.saveBankProducts(bankProducts);
  }

  @PutMapping(UIUtils.BANKPRODUCT_UPD)
  public Mono<ProductBank> updateBankProduct(@RequestBody ProductBank productBank) {
    log.info("Ingreso a updateBankProduct");
    kafkaStringProducer.sendMessage("Ingreso a updateBankProduct" + productBank.toString());
    return bankProductService.updateBankProduct(productBank);
  }

  @DeleteMapping(UIUtils.BANKPRODUCT_DEL)
  public Mono<Void> deleteBankProduct(
      @PathVariable(value = "bankProductId") ObjectId bankProductId) {
    log.info("Ingreso a deleteBankProduct");
    kafkaStringProducer.sendMessage("Ingreso a deleteBankProduct" + bankProductId);
    return bankProductService.deleteBankProduct(bankProductId);
  }

  @GetMapping(UIUtils.BANKPRODUCT_ALL)
  public Flux<ProductBank> getAllBankProducts() {
    log.info("Ingreso a getAllBankProducts");
    kafkaStringProducer.sendMessage("Ingreso a getAllBankProducts");
    return bankProductService.getAllBankProducts();
  }

  @GetMapping(UIUtils.BANKPRODUCT_ID)
  public Mono<ProductBank> getBankProductById(
      @PathVariable(value = "bankProductId") ObjectId bankProductId) {
    log.info("Ingreso a getBankProductById");
    kafkaStringProducer.sendMessage("Ingreso a getBankProductById: " + bankProductId);
    return bankProductService.getBankProductById(bankProductId);
  }
}
