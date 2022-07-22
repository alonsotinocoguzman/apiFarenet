package com.nttdata.msbanco.Model.Implements;

import com.nttdata.msbanco.Model.Entity.Profile;
import com.nttdata.msbanco.Model.Service.ProfileService;
import com.nttdata.msbanco.Repository.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {
  private final ProfileRepository profileRepository;

  @Override
  public Flux<Profile> findAllProfile() {
    return profileRepository.findAll();
  }

  @Override
  public Mono<Profile> findProfileById(Integer idProfile) {
    return profileRepository.findAll().filter(x -> x.getProfileId().equals(idProfile)).elementAt(0);
  }

  @Override
  public Flux<Profile> saveProfile(Flux<Profile> profile) {
    return profileRepository.saveAll(profile);
  }

  @Override
  public Mono<Profile> updateProfile(Profile profile) {
    return profileRepository.save(profile);
  }

  @Override
  public Mono<Void> deleteProfile(ObjectId idProfile) {
    return profileRepository.deleteById(idProfile);
  }
}
