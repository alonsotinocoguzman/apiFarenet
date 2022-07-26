package com.nttdata.msbanco.model.Implements;

import com.nttdata.msbanco.model.Entity.BootCoinPurse;
import com.nttdata.msbanco.model.Service.BootCoinPurseService;
import com.nttdata.msbanco.repository.BootCoinPurseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@Service
public class BootCoinPurseServiceImpl implements BootCoinPurseService {

    BootCoinPurseRepository bootCoinPurseRepository;

    @Override
    public Mono<BootCoinPurse> saveCoinPurse(BootCoinPurse coinPurse) {
        return bootCoinPurseRepository.save(coinPurse);
    }

    @Override
    public Mono<BootCoinPurse> updateCoinPurse(BootCoinPurse coinPurse) {
        return bootCoinPurseRepository.save(coinPurse);
    }

    @Override
    public Mono<Void> deleteCoinPurse(ObjectId id) {
        return bootCoinPurseRepository.deleteById(id);
    }

    @Override
    public Flux<BootCoinPurse> getCoinPurseList() {
        return bootCoinPurseRepository.findAll();
    }

    @Override
    public Mono<BootCoinPurse> getCoinPurse(String documentNumber_cellphoneNumber) {
        return bootCoinPurseRepository.findAll()
                .filter(coinPurse -> coinPurse.getDocumentNumber().equals(documentNumber_cellphoneNumber) || coinPurse.getCellphoneNumber().equals(documentNumber_cellphoneNumber))
                .elementAt(0, new BootCoinPurse(null, "NO ENCONTRADO", "NO ENCONTRADO", "NO ENCONTRADO", "NO ENCONTRADO", 0.0));
    }
}