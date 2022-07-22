package com.nttdata.msbanco.Model.Service;

import com.nttdata.msbanco.Model.Entity.CustomerType;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CustomerTypeService {
    Flux<CustomerType> saveCustomerTypes(List<CustomerType> customerTypes);
    Mono<CustomerType> updateCustomerType(CustomerType customerType);
    Mono<Void> deleteCustomerType(ObjectId customerTypeId);
    Flux<CustomerType> getAllCustomerTypes();
    Mono<CustomerType> getCustomerTypeById(ObjectId customerTypeId);
}