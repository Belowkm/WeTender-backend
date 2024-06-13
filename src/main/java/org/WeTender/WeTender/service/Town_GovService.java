package org.WeTender.WeTender.service;

import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.WeTender.WeTender.model.bo.Town_GovAfterMarketInputBO;
import org.WeTender.WeTender.model.bo.Town_GovCreateProjInputBO;
import org.WeTender.WeTender.model.bo.Town_GovDealInputBO;
import org.WeTender.WeTender.model.bo.Town_GovGetPriceInputBO;
import org.WeTender.WeTender.model.bo.Town_GovGetRevInputBO;
import org.WeTender.WeTender.model.bo.Town_GovGetStatusInputBO;
import org.WeTender.WeTender.model.bo.Town_GovGetTraceInfoInputBO;
import org.WeTender.WeTender.model.bo.Town_GovPassInputBO;
import org.WeTender.WeTender.model.bo.Town_GovProjInputBO;
import org.WeTender.WeTender.model.bo.Town_GovSalaryInputBO;
import org.WeTender.WeTender.model.bo.Town_GovSetBalInputBO;
import org.WeTender.WeTender.model.bo.Town_GovWorkInputBO;
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
public class Town_GovService {
  public static final String ABI = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("abi/Town_Gov.abi");

  public static final String BINARY = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("bin/ecc/Town_Gov.bin");

  public static final String SM_BINARY = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("bin/sm/Town_Gov.bin");

  @Value("${system.contract.town_GovAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public TransactionResponse Pass(Town_GovPassInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Pass", input.toArgs());
  }

  public CallResponse proj(Town_GovProjInputBO input) throws Exception {
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

  public CallResponse getStatus(Town_GovGetStatusInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getStatus", input.toArgs());
  }

  public TransactionResponse setBal(Town_GovSetBalInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "setBal", input.toArgs());
  }

  public TransactionResponse Deal(Town_GovDealInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Deal", input.toArgs());
  }

  public TransactionResponse AfterMarket(Town_GovAfterMarketInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "AfterMarket", input.toArgs());
  }

  public TransactionResponse Work(Town_GovWorkInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Work", input.toArgs());
  }

  public CallResponse num() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "num", Arrays.asList());
  }

  public CallResponse getPrice(Town_GovGetPriceInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getPrice", input.toArgs());
  }

  public CallResponse getAddress() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getAddress", Arrays.asList());
  }

  public CallResponse getRev(Town_GovGetRevInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getRev", input.toArgs());
  }

  public CallResponse getTraceInfo(Town_GovGetTraceInfoInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getTraceInfo", input.toArgs());
  }

  public TransactionResponse Salary(Town_GovSalaryInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Salary", input.toArgs());
  }

  public TransactionResponse CreateProj(Town_GovCreateProjInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "CreateProj", input.toArgs());
  }
}
