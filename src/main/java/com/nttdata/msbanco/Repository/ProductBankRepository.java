package com.nttdata.msbanco.Repository;

import com.nttdata.msbanco.Model.Entity.ProductBank;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBankRepository extends ReactiveCrudRepository<ProductBank, ObjectId> {}
