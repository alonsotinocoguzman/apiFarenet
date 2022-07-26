package com.nttdata.msbanco.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "BootCoinExchangeRate")
public class BootCoinExchangeRate {
    @Id
    private ObjectId id;
    private Double purchaseInCurrency;
    private Double salesInCurrency;
    private String currency;
}