package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.kafka.producer.KafkaStringProducer;
import com.nttdata.msbanco.model.Entity.Profile;
import com.nttdata.msbanco.model.Service.ProfileService;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(UIUtils.BASE_URL_PROFILE)
@Slf4j
@AllArgsConstructor
public class ProfileController {
  private final ProfileService profileService;
  private final KafkaStringProducer kafkaStringProducer;

  @GetMapping(UIUtils.PROFILE_ALL)
  public Flux<Profile> getAllProfile() {
    log.info("Ingreso a getAllProfile");
    kafkaStringProducer.sendMessage("Ingreso a getAllProfile");
    return profileService.findAllProfile();
  }

  @GetMapping(UIUtils.PROFILE_ID)
  public Mono<Profile> getProfileById(@PathVariable(value = "idProfile") Integer idProfile) {
    log.info("Ingreso a getProfileById");
    kafkaStringProducer.sendMessage("Ingreso a getProfileById: " + idProfile);
    return profileService.findProfileById(idProfile);
  }

  @PostMapping(UIUtils.PROFILE_INS)
  public Flux<Profile> saveProfile(@RequestBody Flux<Profile> Profile) {
    log.info("Ingreso a saveProfile");
    kafkaStringProducer.sendMessage("Ingreso a saveProfile");
    return profileService.saveProfile(Profile);
  }

  @PutMapping(UIUtils.PROFILE_UPD)
  public Mono<Profile> updateProfile(@RequestBody Profile Profile) {
    log.info("Ingreso a updateProfile");
    kafkaStringProducer.sendMessage("Ingreso a updateProfile: " + Profile.toString());
    return profileService.updateProfile(Profile);
  }

  @DeleteMapping(UIUtils.PROFILE_DEL)
  public Mono<Void> deleteProfile(@PathVariable(value = "id") ObjectId idProfile) {
    log.info("Ingreso a deleteProfile");
    kafkaStringProducer.sendMessage("Ingreso a deleteProfile: " + idProfile);
    return profileService.deleteProfile(idProfile);
  }
}
