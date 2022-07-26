package com.nttdata.msbanco.controller;

import com.nttdata.msbanco.model.Entity.BootCoinPurse;
import com.nttdata.msbanco.model.Service.BootCoinPurseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("bootcoin-purse")
public class BootCoinPurseController {

    private BootCoinPurseService bootCoinPurseService;

    @PostMapping("save")
    public Mono<BootCoinPurse> saveCoinPurse(@RequestBody BootCoinPurse coinPurse) {
        return bootCoinPurseService.saveCoinPurse(coinPurse);
    }

    @PutMapping("update")
    public Mono<BootCoinPurse> updateCoinPurse(@RequestBody BootCoinPurse coinPurse) {
        return bootCoinPurseService.updateCoinPurse(coinPurse);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteCoinPurse(@PathVariable(value = "id") ObjectId id) {
        return bootCoinPurseService.deleteCoinPurse(id);
    }

    @GetMapping("find-all")
    public Flux<BootCoinPurse> getCoinPurseList() {
        return bootCoinPurseService.getCoinPurseList();
    }

    @GetMapping("find-id/{documentNumber}")
    public Mono<BootCoinPurse> getCoinPurse(@PathVariable(value = "documentNumber") String documentNumber_cellphoneNumber) {
        return bootCoinPurseService.getCoinPurse(documentNumber_cellphoneNumber);
    }
}