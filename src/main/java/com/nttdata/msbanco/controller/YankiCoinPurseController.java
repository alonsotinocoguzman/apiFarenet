package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.model.Entity.YankiCoinPurse;
import com.nttdata.msbanco.model.Service.YankiCoinPurseService;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(UIUtils.YANKI_COIN_PURSE_BASEURL)
public class YankiCoinPurseController {
    private YankiCoinPurseService yankiCoinPurseService;

    @PostMapping(UIUtils.YANKI_COIN_PURSE_INS)
    public Mono<YankiCoinPurse> saveYankiCoinPurse(@RequestBody YankiCoinPurse yankiCoinPurse) {
        return yankiCoinPurseService.saveYankiCoinPurse(yankiCoinPurse);
    }

    @PutMapping(UIUtils.YANKI_COIN_PURSE_UPD)
    public Mono<YankiCoinPurse> updateYankiCoinPurse(@RequestBody YankiCoinPurse yankiCoinPurse) {
        return yankiCoinPurseService.saveYankiCoinPurse(yankiCoinPurse);
    }

    @DeleteMapping(UIUtils.YANKI_COIN_PURSE_DEL)
    public Mono<Void> deleteYankiCoinPurse(@PathVariable(value = "coinPurseId") ObjectId id) {
        return yankiCoinPurseService.deleteYankiCoinPurse(id);
    }

    @GetMapping(UIUtils.YANKI_COIN_PURSE_ALL)
    public Flux<YankiCoinPurse> getAllYankiCoinPurses() {
        return yankiCoinPurseService.getAllYankiCoinPurses();
    }

    @GetMapping(UIUtils.YANKI_COIN_PURSE_ID)
    public Mono<YankiCoinPurse> getYankiCoinPurse(@PathVariable(value = "coinPurseDocumentNumber") String documentNumber) {
        return yankiCoinPurseService.getYankiCoinPurse(documentNumber);
    }
}