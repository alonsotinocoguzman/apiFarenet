package com.nttdata.msbanco.Repository;

import com.nttdata.msbanco.Model.Entity.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, ObjectId> {}
