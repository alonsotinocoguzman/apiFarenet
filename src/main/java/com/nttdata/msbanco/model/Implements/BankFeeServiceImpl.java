package com.nttdata.msbanco.model.Implements;

import com.mongodb.BasicDBObject;
import com.nttdata.msbanco.model.Entity.BankFee;
import com.nttdata.msbanco.model.Service.BankFeeService;
import com.nttdata.msbanco.repository.BankFeeRespository;
import com.nttdata.msbanco.utils.UIUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Slf4j
@AllArgsConstructor
@Service
public class BankFeeServiceImpl implements BankFeeService {
    private final BankFeeRespository bankFeeRespository;
    @Override
    public Mono<BankFee> saveBankFee(BankFee bankFee) {
        return bankFeeRespository.save(bankFee);
    }

    @Override
    public Mono<BankFee> updateBankFee(BankFee bankFee) {
        return bankFeeRespository.save(bankFee);
    }

    @Override
    public Mono<Void> deleteBankFee(ObjectId id) {
        return bankFeeRespository.deleteById(id);
    }

    @Override
    public Flux<BankFee> getAllBankFee() {
        return bankFeeRespository.findAll();
    }

    @Override
    public Mono<BankFee> getBankFee(String id) {
        UIUtils uiUtils= new UIUtils();
        return bankFeeRespository.findById(uiUtils.getObjectId(id));
    }
}
