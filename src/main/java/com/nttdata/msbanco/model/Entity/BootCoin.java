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
@Document(collection = "BootCoin")
public class BootCoin {
  @Id private ObjectId id;
  private String cellphoneNumber;
  private String documentNumber;
  private String email;
  private Double amount;
  private String paymentMethod;
  private Boolean isAccepted;
  private String transactionNumber;
  private String accountNumber;
  private String idBankFee;
  private String message;
}
