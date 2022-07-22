package com.nttdata.msbanco.Repository;

import com.nttdata.msbanco.Model.Entity.Profile;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProfileRepository extends ReactiveCrudRepository<Profile, ObjectId> {}
