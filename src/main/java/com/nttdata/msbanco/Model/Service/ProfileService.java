package com.nttdata.msbanco.Model.Service;

import com.nttdata.msbanco.Model.Entity.Profile;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfileService {
    Flux<Profile> findAllProfile();

    Mono<Profile> findProfileById(Integer idProfile);

    Flux<Profile> saveProfile(Flux<Profile> accountType);

    Mono<Profile> updateProfile(Profile accountType);

    Mono<Void> deleteProfile(ObjectId idProfile);
}
