package com.nttdata.msbanco.model.Entity.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BootCoinDto {
    private String cellphoneNumber;
    private String accountNumber;
    private Double amount;
    private String transactionNumber;
    private String paymentMethod;
}
