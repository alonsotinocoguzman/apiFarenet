package com.nttdata.msbanco.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transaction")
public class Transaction {
  @Id private String id;
  private String accountType;
  private String customerType;
  private String productBank;
  private Double balance;
  private Double creditLimit;
  private Double debitBalance;
  private Date creationDate;
  private String transactionTypeCode;
}