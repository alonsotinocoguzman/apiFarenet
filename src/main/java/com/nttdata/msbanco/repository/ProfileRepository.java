package com.nttdata.msbanco.repository;

import com.nttdata.msbanco.model.Entity.Profile;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProfileRepository extends ReactiveCrudRepository<Profile, ObjectId> {}
