package org.WeTender.WeTender.service;

import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.WeTender.WeTender.model.bo.County_GovAddTownInputBO;
import org.WeTender.WeTender.model.bo.County_GovAfterMarketInputBO;
import org.WeTender.WeTender.model.bo.County_GovCheckTownInputBO;
import org.WeTender.WeTender.model.bo.County_GovCreateProjInputBO;
import org.WeTender.WeTender.model.bo.County_GovDealInputBO;
import org.WeTender.WeTender.model.bo.County_GovGetPriceInputBO;
import org.WeTender.WeTender.model.bo.County_GovGetRevInputBO;
import org.WeTender.WeTender.model.bo.County_GovGetStatusInputBO;
import org.WeTender.WeTender.model.bo.County_GovGetTraceInfoInputBO;
import org.WeTender.WeTender.model.bo.County_GovPassInputBO;
import org.WeTender.WeTender.model.bo.County_GovProjInputBO;
import org.WeTender.WeTender.model.bo.County_GovRemoveTownInputBO;
import org.WeTender.WeTender.model.bo.County_GovSalaryInputBO;
import org.WeTender.WeTender.model.bo.County_GovSetBalInputBO;
import org.WeTender.WeTender.model.bo.County_GovWorkInputBO;
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
public class County_GovService {
  public static final String ABI = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("abi/County_Gov.abi");

  public static final String BINARY = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("bin/ecc/County_Gov.bin");

  public static final String SM_BINARY = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("bin/sm/County_Gov.bin");

  @Value("${system.contract.county_GovAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public TransactionResponse Pass(County_GovPassInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Pass", input.toArgs());
  }

  public CallResponse proj(County_GovProjInputBO input) throws Exception {
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

  public TransactionResponse removeTown(County_GovRemoveTownInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "removeTown", input.toArgs());
  }

  public CallResponse getStatus(County_GovGetStatusInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getStatus", input.toArgs());
  }

  public TransactionResponse setBal(County_GovSetBalInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "setBal", input.toArgs());
  }

  public TransactionResponse addTown(County_GovAddTownInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "addTown", input.toArgs());
  }

  public TransactionResponse Deal(County_GovDealInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Deal", input.toArgs());
  }

  public TransactionResponse AfterMarket(County_GovAfterMarketInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "AfterMarket", input.toArgs());
  }

  public TransactionResponse Work(County_GovWorkInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Work", input.toArgs());
  }

  public CallResponse num() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "num", Arrays.asList());
  }

  public CallResponse getPrice(County_GovGetPriceInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getPrice", input.toArgs());
  }

  public CallResponse getRev(County_GovGetRevInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getRev", input.toArgs());
  }

  public CallResponse getTraceInfo(County_GovGetTraceInfoInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getTraceInfo", input.toArgs());
  }

  public CallResponse checkTown(County_GovCheckTownInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "checkTown", input.toArgs());
  }

  public TransactionResponse Salary(County_GovSalaryInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Salary", input.toArgs());
  }

  public TransactionResponse CreateProj(County_GovCreateProjInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "CreateProj", input.toArgs());
  }
}
