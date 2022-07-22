package com.nttdata.msbanco.repository;

import com.nttdata.msbanco.model.Entity.Card;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CardRepository extends ReactiveCrudRepository<Card, String> {}
