package com.nttdata.msbanco.repository;

import com.nttdata.msbanco.model.Entity.BankFee;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BankFeeRespository extends ReactiveCrudRepository<BankFee, ObjectId> {
}
