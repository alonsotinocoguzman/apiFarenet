package com.nttdata.msbanco.model.Implements;

import com.nttdata.msbanco.model.Entity.BankFee;
import com.nttdata.msbanco.model.Entity.BootCoin;
import com.nttdata.msbanco.model.Entity.Dto.BootCoinDto;
import com.nttdata.msbanco.model.Service.BootCoinService;
import com.nttdata.msbanco.repository.BankFeeRespository;
import com.nttdata.msbanco.repository.BootCoinRepository;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Slf4j
@AllArgsConstructor
@Service
public class BootCoinServiceImpl implements BootCoinService {
  private final BootCoinRepository bootCoinRepository;
  private final BankFeeRespository bankFeeRespository;

  @Override
  public Mono<BootCoin> saveBootCoin(BootCoin bootCoin) {
    if (!validateObject(bootCoin))
      return Mono.error(new IOException("debe ingresar campos validos"));
    if (!validateAmountAndPaymentMethod(bootCoin))
      return Mono.error(new IOException("debe ingresar valores validos"));
    return bootCoinRepository.save(bootCoin);
  }

  @Override
  public Mono<BootCoin> updateBootCoin(BootCoin bootCoin) {
    return bootCoinRepository.save(bootCoin);
  }

  @Override
  public Mono<Void> deleteBootCoin(ObjectId id) {
    return bootCoinRepository.deleteById(id);
  }

  @Override
  public Flux<BootCoin> getAllBootCoin() {
    return bootCoinRepository.findAll();
  }

  @Override
  public Mono<BootCoin> getBootCoin(String id) {
    UIUtils utils = new UIUtils();
    return bootCoinRepository.findById(utils.getObjectId(id));
  }

  @Override
  public Mono<BootCoin> acceptTransaction(String id, Boolean isAccepted, String bankFeeId) {
    UIUtils utils = new UIUtils();
    bootCoinRepository
        .findById(utils.getObjectId(id))
        .flatMap(
            z -> {
              if (isAccepted) {
                log.info("si");
                z.setTransactionNumber("Trn-Ope" + id);
                z.setIsAccepted(isAccepted);
                return this.bootCoinRepository.save(z);
              } else Mono.error(new IOException("la operacion no está aceptada"));
              return Mono.just("transacction no aceptada");
            });
    return Mono.empty();
  }

  @Override
  public Mono<BootCoin> validateTransaction(BootCoinDto bootCoinDto) throws IOException {
    String id = bootCoinDto.getTransactionNumber().substring(7);
    UIUtils utils = new UIUtils();
    return bootCoinRepository
        .findById(utils.getObjectId(id))
        .flatMap(
            z -> {
              log.info("aqui");
              Mono<BankFee> listMono =
                  bankFeeRespository.findById(utils.getObjectId(z.getIdBankFee()));
                log.info("listMono: "+ listMono.map(BankFee::getPurchaseRate).subscribe());
              BankFee bankFee = new BankFee();
              bankFee.setPurchaseRate(listMono.map(BankFee::getPurchaseRate).block());
              bankFee.setSalesRate(listMono.map(BankFee::getSalesRate).block());
              log.info("valor: " + bankFee.getPurchaseRate());
              if (!z.getAmount().equals(bootCoinDto.getAmount())) {
                log.info("si");
                Mono.error(
                    new IOException(
                        "El monto no es igual al ingresado en la transaccion: "
                            + bootCoinDto.getTransactionNumber()));
              }
                if (!z.getPaymentMethod().equals(bootCoinDto.getPaymentMethod())) {
                    log.info("si");
                    Mono.error(
                            new IOException(
                                    "El metodo de pago no es igual al ingresado en la transaccion: "
                                            + bootCoinDto.getTransactionNumber()));
                }
                if (!z.getAccountNumber().equals(bootCoinDto.getAccountNumber())) {
                    log.info("si");
                    Mono.error(
                            new IOException(
                                    "El numero de cuenta no es igual al ingresado en la transaccion: "
                                            + bootCoinDto.getTransactionNumber()));
                }
                if (!z.getCellphoneNumber().equals(bootCoinDto.getCellphoneNumber())){
                    log.info("si");
                    Mono.error(
                            new IOException(
                                    "El numero de celular no es igual al ingresado en la transaccion: "
                                            + bootCoinDto.getTransactionNumber()));}
              if (z.getPaymentMethod().equals("COMPRA")) {
                log.info("entro a la compra");
                z.setAmount(z.getAmount() / bankFee.getPurchaseRate());
              } else {
                log.info("entro a la venta");
                z.setAmount(z.getAmount() / listMono.map(BankFee::getSalesRate).block());
              }
              return this.bootCoinRepository.save(z);
            });
    /*bootCoinRepository
        .findById(utils.getObjectId(id))
        .switchIfEmpty(
            Mono.error(
                new IOException("no existe movimientos para la transaccion: " + bootCoinDto.getTransactionNumber())))
        .flatMap(
            saveData -> {
              log.info("si");
              Mono<BankFee> listMono =
                  bankFeeRespository.findById(utils.getObjectId(saveData.getIdBankFee()));
              if (!saveData.getAmount().equals(bootCoinDto.getAmount())) {
                log.info("si");
                Mono.error(
                    new IOException(
                        "El monto no es igual al ingresado en la transaccion: "
                            + bootCoinDto.getTransactionNumber()));
              }
              if (!saveData.getPaymentMethod().equals(bootCoinDto.getPaymentMethod())) {
                log.info("si");
                Mono.error(
                    new IOException(
                        "El metodo de pago no es igual al ingresado en la transaccion: "
                            + bootCoinDto.getTransactionNumber()));
              }
              if (!saveData.getAccountNumber().equals(bootCoinDto.getAccountNumber())) {
                log.info("si");
                Mono.error(
                    new IOException(
                        "El numero de cuenta no es igual al ingresado en la transaccion: "
                            + bootCoinDto.getTransactionNumber()));
              }
              if (!saveData.getCellphoneNumber().equals(bootCoinDto.getCellphoneNumber())){
                log.info("si");
                Mono.error(
                    new IOException(
                        "El numero de celular no es igual al ingresado en la transaccion: "
                            + bootCoinDto.getTransactionNumber()));}
              if (saveData.getPaymentMethod().equals("COMPRA"))
                saveData.setAmount(
                    saveData.getAmount() / listMono.map(BankFee::getPurchaseRate).block());
              else
                saveData.setAmount(
                    saveData.getAmount() / listMono.map(BankFee::getSalesRate).block());
              return bootCoinRepository.save(saveData);
            });
    return Mono.just(new BootCoin());*/
  }

  private boolean validateObject(BootCoin bootCoin) {
    boolean flag = false;
    if (!bootCoin.getCellphoneNumber().isEmpty()) flag = true;
    if (!bootCoin.getDocumentNumber().isEmpty()) flag = true;
    if (!bootCoin.getEmail().isEmpty()) flag = true;
    return flag;
  }

  private boolean validateAmountAndPaymentMethod(BootCoin bootCoin) {
    boolean flag = false;
    if (!bootCoin.getPaymentMethod().isEmpty()) flag = true;
    if (!bootCoin.getAmount().equals(0)) flag = true;
    return flag;
  }
}
