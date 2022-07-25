package com.nttdata.msbanco.model.Implements;

import com.nttdata.msbanco.model.Entity.YankiCoinPurse;
import com.nttdata.msbanco.model.Service.YankiCoinPurseService;
import com.nttdata.msbanco.repository.YankiCoinPurseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Slf4j
@Service
@AllArgsConstructor
public class YankiCoinPurseServiceImpl implements YankiCoinPurseService {

  private YankiCoinPurseRepository yankiCoinPurseRepository;

  @Override
  public Mono<YankiCoinPurse> saveYankiCoinPurse(YankiCoinPurse yankiCoinPurse) {
    return yankiCoinPurseRepository.save(yankiCoinPurse);
  }

  @Override
  public Mono<YankiCoinPurse> updateYankiCoinPurse(YankiCoinPurse yankiCoinPurse) {
    return yankiCoinPurseRepository.save(yankiCoinPurse);
  }

  @Override
  public Mono<Void> deleteYankiCoinPurse(ObjectId id) {
    return yankiCoinPurseRepository.deleteById(id);
  }

  @Override
  public Flux<YankiCoinPurse> getAllYankiCoinPurses() {
    return yankiCoinPurseRepository.findAll();
  }

  @Override
  public Mono<YankiCoinPurse> getYankiCoinPurse(String documentNumber) {
    return yankiCoinPurseRepository
        .findAll()
        .filter(coinPurse -> coinPurse.getDocumentNumber().equals(documentNumber))
        .elementAt(0)
        .defaultIfEmpty(new YankiCoinPurse());
  }

  @Override
  public Mono<YankiCoinPurse> sendAndReceiveYankiCoinPurse(YankiCoinPurse yankiCoinPurse) {
    yankiCoinPurseRepository
        .findAll()
        .filter(nroCel -> nroCel.getCellphoneNumber().equals(yankiCoinPurse.getCellphoneNumber()))
        .map(
            saveInfo -> {
              if (!yankiCoinPurse.getCellphoneNumber().isEmpty()) {
                switch (saveInfo.getOperationType()) {
                  case "SENT":
                    if (saveInfo.getAvailableBalance() == 0) {
                      log.info("No cuenta con saldo suficiente: " + saveInfo.getAvailableBalance());
                      Mono.error(new IOException("No cuenta con saldo suficiente"));
                    }
                    if (saveInfo.getAvailableBalance() < yankiCoinPurse.getAmountSent()) {
                      log.info(
                          "El importe a enviar debe ser menor o igual al saldo disponible"
                              + saveInfo.getAvailableBalance());
                      Mono.error(new IOException("No cuenta con saldo suficiente"));
                    }
                    yankiCoinPurse.setAvailableBalance(
                        saveInfo.getAvailableBalance() - yankiCoinPurse.getAmountSent());
                    break;
                  case "RECEIVE":
                    if (yankiCoinPurse.getAmountReceive() < 0) {
                      log.info(
                          "No puedes cargar importes negativos "
                              + yankiCoinPurse.getAmountReceive());
                      Mono.error(new IOException("No puedes cargar importes negativos"));
                    }
                    yankiCoinPurse.setAvailableBalance(
                        saveInfo.getAvailableBalance() + yankiCoinPurse.getAmountSent());
                }
              } else {
                log.info(
                    "Es necesario ingresar su numero de celular "
                        + yankiCoinPurse.getCellphoneNumber());
                Mono.error(new IOException("Es necesario ingresar su numero de celular"));
              }
              return yankiCoinPurseRepository.save(yankiCoinPurse);
            });
    return Mono.empty();
  }
}
