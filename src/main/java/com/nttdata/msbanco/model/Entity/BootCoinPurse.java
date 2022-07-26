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
@Document(collection = "BootCoinPurse")
public class BootCoinPurse {
    @Id
    private ObjectId id;
    private String documentType;
    private String documentNumber;
    private String cellphoneNumber;
    private String email;
    private Double availableBalance;
}