package org.WeTender.WeTender.service;

import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.WeTender.WeTender.model.bo.GovernmentAfterMarketInputBO;
import org.WeTender.WeTender.model.bo.GovernmentCreateProjInputBO;
import org.WeTender.WeTender.model.bo.GovernmentDealInputBO;
import org.WeTender.WeTender.model.bo.GovernmentGetPriceInputBO;
import org.WeTender.WeTender.model.bo.GovernmentGetRevInputBO;
import org.WeTender.WeTender.model.bo.GovernmentGetStatusInputBO;
import org.WeTender.WeTender.model.bo.GovernmentGetTraceInfoInputBO;
import org.WeTender.WeTender.model.bo.GovernmentPassInputBO;
import org.WeTender.WeTender.model.bo.GovernmentProjInputBO;
import org.WeTender.WeTender.model.bo.GovernmentSalaryInputBO;
import org.WeTender.WeTender.model.bo.GovernmentSetBalInputBO;
import org.WeTender.WeTender.model.bo.GovernmentWorkInputBO;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor;
import org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory;
import org.fisco.bcos.sdk.transaction.model.dto.CallResponse;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Data
public class GovernmentService {
  public static final String ABI = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("abi/Government.abi");

  public static final String BINARY = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("bin/ecc/Government.bin");

  public static final String SM_BINARY = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("bin/sm/Government.bin");

  @Value("${system.contract.governmentAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public TransactionResponse Pass(GovernmentPassInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Pass", input.toArgs());
  }

  public CallResponse proj(GovernmentProjInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "proj", input.toArgs());
  }

  public CallResponse rev() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "rev", Arrays.asList());
  }

  public CallResponse gov_name() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "gov_name", Arrays.asList());
  }

  public CallResponse bal() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "bal", Arrays.asList());
  }

  public CallResponse getStatus(GovernmentGetStatusInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getStatus", input.toArgs());
  }

  public TransactionResponse setBal(GovernmentSetBalInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "setBal", input.toArgs());
  }

  public TransactionResponse Deal(GovernmentDealInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Deal", input.toArgs());
  }

  public TransactionResponse AfterMarket(GovernmentAfterMarketInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "AfterMarket", input.toArgs());
  }

  public TransactionResponse Work(GovernmentWorkInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Work", input.toArgs());
  }

  public CallResponse num() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "num", Arrays.asList());
  }

  public CallResponse getPrice(GovernmentGetPriceInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getPrice", input.toArgs());
  }

  public CallResponse getAddress() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getAddress", Arrays.asList());
  }

  public CallResponse getRev(GovernmentGetRevInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getRev", input.toArgs());
  }

  public CallResponse getTraceInfo(GovernmentGetTraceInfoInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getTraceInfo", input.toArgs());
  }

  public TransactionResponse Salary(GovernmentSalaryInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Salary", input.toArgs());
  }

  public TransactionResponse CreateProj(GovernmentCreateProjInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "CreateProj", input.toArgs());
  }
}
