package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.kafka.producer.KafkaStringProducer;
import com.nttdata.msbanco.model.Entity.CustomerType;
import com.nttdata.msbanco.model.Service.CustomerTypeService;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(UIUtils.CUSTOMERTYPE_BASEURL)
@Slf4j
@AllArgsConstructor
public class CustomerTypeController {
  private final CustomerTypeService customerTypeService;
  private final KafkaStringProducer kafkaStringProducer;

  @PostMapping(UIUtils.CUSTOMERTYPE_INS)
  public Flux<CustomerType> saveCustomerTypes(@RequestBody List<CustomerType> customerTypes) {
    log.info("Ingreso a saveCustomerTypes");
    kafkaStringProducer.sendMessage("Ingreso a saveCustomerTypes");
    return customerTypeService.saveCustomerTypes(customerTypes);
  }

  @PutMapping(UIUtils.CUSTOMERTYPE_UPD)
  public Mono<CustomerType> updateCustomerType(@RequestBody CustomerType customerType) {
    log.info("Ingreso a updateCustomerType");
    kafkaStringProducer.sendMessage("Ingreso a updateCustomerType " + customerType.toString());
    return customerTypeService.updateCustomerType(customerType);
  }

  @DeleteMapping(UIUtils.CUSTOMERTYPE_DEL)
  public Mono<Void> deleteCustomerType(
      @PathVariable(value = "customerTypeId") ObjectId customerTypeId) {
    log.info("Ingreso a deleteCustomerType");
    kafkaStringProducer.sendMessage("Ingreso a deleteCustomerType " + customerTypeId);
    return customerTypeService.deleteCustomerType(customerTypeId);
  }

  @GetMapping(UIUtils.CUSTOMERTYPE_ALL)
  public Flux<CustomerType> getAllCustomerTypes() {
    log.info("Ingreso a getAllCustomerTypes");
    kafkaStringProducer.sendMessage("Ingreso a getAllCustomerTypes");
    return customerTypeService.getAllCustomerTypes();
  }

  @GetMapping(UIUtils.CUSTOMERTYPE_ID)
  public Mono<CustomerType> getCustomerType(
      @PathVariable(value = "customerTypeId") ObjectId customerTypeId) {
    log.info("Ingreso a getCustomerType");
    kafkaStringProducer.sendMessage("Ingreso a getCustomerType: " + customerTypeId);
    return customerTypeService.getCustomerTypeById(customerTypeId);
  }
}
