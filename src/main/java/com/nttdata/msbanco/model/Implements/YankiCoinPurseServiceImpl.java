package com.nttdata.msbanco.model.Implements;

import com.nttdata.msbanco.model.Entity.YankiCoinPurse;
import com.nttdata.msbanco.model.Service.YankiCoinPurseService;
import com.nttdata.msbanco.repository.YankiCoinPurseRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
}