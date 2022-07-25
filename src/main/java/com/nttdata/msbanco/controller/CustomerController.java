package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.kafka.producer.KafkaStringProducer;
import com.nttdata.msbanco.model.Entity.Customer;
import com.nttdata.msbanco.model.Service.CustomerService;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(UIUtils.BASEURL)
@Slf4j
@AllArgsConstructor
public class CustomerController {
  private final CustomerService customerService;
  private final KafkaStringProducer kafkaStringProducer;

  @GetMapping(UIUtils.CUSTOMER_ALL)
  public Flux<Customer> getAllCustomer() {
    log.info("Ingreso a getAllCustomer");
    kafkaStringProducer.sendMessage("Ingreso a getAllCustomer");
    return customerService.findAll();
  }

  @GetMapping(UIUtils.CUSTOMER_ID)
  public Mono<Customer> getCustomerByDocumentNumber(
      @PathVariable(value = "documentNumber") String documentNumber) {
    log.info("Ingreso a getCustomerByDocumentNumber");
    kafkaStringProducer.sendMessage("Ingreso a getCustomerByDocumentNumber: " + documentNumber);
    return customerService.findByDocumentNumber(documentNumber);
  }

  @PostMapping(UIUtils.CUSTOMER_INS)
  public Mono<Customer> saveCustomer(@RequestBody Customer customer) {
    log.info("Ingreso a saveCustomer");
    kafkaStringProducer.sendMessage("Ingreso a saveCustomer: " + customer.toString());
    return customerService.saveCustomer(customer);
  }

  @PutMapping(UIUtils.CUSTOMER_UPD)
  public Mono<Customer> updateCustomer(@RequestBody Customer customer) {
    log.info("Ingreso a updateCustomer");
    kafkaStringProducer.sendMessage("Ingreso a updateCustomer: " + customer.toString());
    return customerService.updateCustomer(customer);
  }

  @DeleteMapping(UIUtils.CUSTOMER_DEL)
  public Mono<Void> deleteCustomer(@PathVariable(value = "customerId") ObjectId customerId) {
    log.info("Ingreso a deleteCustomer");
    kafkaStringProducer.sendMessage("Ingreso a deleteCustomer: " + customerId);
    return customerService.deleteCustomer(customerId);
  }

  @GetMapping(UIUtils.CUSTOMER_ALL_PRODUCTS)
  public Flux<Object> getCustomerAllProucts(
      @RequestParam(value = "nroDocumento") String nroDocumento) {
    kafkaStringProducer.sendMessage("Ingreso a getCustomerAllProucts: " + nroDocumento);
    return customerService.getCustomerAllProucts(nroDocumento);
  }
}
