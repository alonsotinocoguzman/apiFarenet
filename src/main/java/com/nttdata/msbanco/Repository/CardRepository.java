package com.nttdata.msbanco.Repository;

import com.nttdata.msbanco.Model.Entity.Card;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CardRepository extends ReactiveCrudRepository<Card, String> {}
