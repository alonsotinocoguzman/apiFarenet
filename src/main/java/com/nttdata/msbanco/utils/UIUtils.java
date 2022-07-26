package com.nttdata.msbanco.utils;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;

public class UIUtils {
  public static final String BASEURL = "/customer";
  public static final String BASEURLACCOUNTTYPE = "/account-type";
  public static final String CUSTOMER_ALL = "/find-all";
  public static final String CUSTOMER_ID = "/find-id/{documentNumber}";
  public static final String CUSTOMER_INS = "save";
  public static final String CUSTOMER_UPD = "update";
  public static final String CUSTOMER_DEL = "delete/{customerId}";
  public static final String CUSTOMER_ALL_PRODUCTS = "/customer-all-products";
  public static final String BANKPRODUCT_BASEURL = "productbank";
  public static final String BANKPRODUCT_INS = "save";
  public static final String BANKPRODUCT_UPD = "update";
  public static final String BANKPRODUCT_DEL = "delete/{bankProductId}";
  public static final String BANKPRODUCT_ALL = "find-all";
  public static final String BANKPRODUCT_ID = "find-id/{bankProductId}";
  public static final String CUSTOMERTYPE_BASEURL = "customertype";
  public static final String CUSTOMERTYPE_INS = "save";
  public static final String CUSTOMERTYPE_UPD = "update";
  public static final String CUSTOMERTYPE_DEL = "delete/{customerTypeId}";
  public static final String CUSTOMERTYPE_ALL = "find-all";
  public static final String CUSTOMERTYPE_ID = "find-id/{customerTypeId}";
  public static final String ACCOUNT_TYPE_ALL = "/find-all";
  public static final String ACCOUNT_TYPE_ID = "/find-id/{idAccountType}";
  public static final String ACCOUNT_TYPE_INS = "save";
  public static final String ACCOUNT_TYPE_UPD = "update";
  public static final String ACCOUNT_TYPE_DEL = "delete/{id}";
  public static final String BASEURL_TRANSACTION = "/transaction";
  public static final String TRANSACTION_ALL = "/find-all";
  public static final String TRANSACTION_ID = "/find-id/{id}";
  public static final String TRANSACTION_INS = "save";
  public static final String TRANSACTION_UPD = "update";
  public static final String TRANSACTION_DEL = "delete/{id}";
  public static final String TRANSACTION_BALANCE = "balance/{id}";
  public static final String BASEURL_CARD = "/card";
  public static final String CARD_CREATE = "/card-create";
  public static final String CARD_PAY_BALANCE = "/pay-balance";
  public static final String CARD_GET_BALANCE = "/debit-credit";
  public static final String CARD_LOAD_BALANCE = "/load-balance/{id}";
  public static final String BASE_URL_PROFILE = "/profile";
  public static final String PROFILE_ALL = "/find-all";
  public static final String PROFILE_ID = "/find-id/{idAccountType}";
  public static final String PROFILE_INS = "save";
  public static final String PROFILE_UPD = "update";
  public static final String PROFILE_DEL = "delete/{id}";
  public static final String BANKACCOUNT_BASEURL = "bankaccount";
  public static final String BANKACCOUNT_INS = "save";
  public static final String BANKACCOUNT_UPD = "update";
  public static final String BANKACCOUNT_DEL = "delete/{bankAccountId}";
  public static final String BANKACCOUNT_ALL_BY_CUSTOMER = "find-all-customer/{documentNumber}";
  public static final String BANKACCOUNT_ID = "find-id/{bankAccountId}";
  public static final String TRANSACTION_TYPE_BASEURL = "transaction-type";
  public static final String TRANSACTION_TYPE_INS = "save";
  public static final String TRANSACTION_TYPE_UPD = "update";
  public static final String TRANSACTION_TYPE_DEL = "delete/{transactionTypeId}";
  public static final String TRANSACTION_TYPE_ALL = "find-all";
  public static final String TRANSACTION_TYPE_ID = "find-id/{transactionTypeCode}";
  public static final String YANKI_COIN_PURSE_BASEURL = "coin-purse";
  public static final String YANKI_COIN_PURSE_INS = "save";
  public static final String YANKI_COIN_PURSE_SEND_RECEIVE_INS = "send-receive";
  public static final String YANKI_COIN_PURSE_UPD = "update";
  public static final String YANKI_COIN_PURSE_DEL = "delete/{coinPurseId}";
  public static final String YANKI_COIN_PURSE_ALL = "find-all";
  public static final String YANKI_COIN_PURSE_ID = "find-id/{coinPurseDocumentNumber}";

  public static final String BOOT_COIN_BASE = "boot-coin";
  public static final String BOOT_COIN_SAVE = "boot-coin-save";
  public static final String BOOT_COIN_APPROVE = "boot-coin-approve";
  public static final String BOOT_COIN_TRACKING = "boot-coin-tracking";
  public static final String BANK_FEE_BASE = "bank-fee";
  public static final String BANK_FEE_INS = "bank-fee-save";

  @Bean
  public ObjectId getObjectId(String id) {
    ObjectId objectId = new ObjectId(id);
    return objectId;
  }
}
