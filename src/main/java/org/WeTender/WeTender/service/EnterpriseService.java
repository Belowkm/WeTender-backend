package org.WeTender.WeTender.service;

import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.WeTender.WeTender.model.bo.EnterpriseAddProfitInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseAddProjInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseAfterMarket_etpInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseBuildInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseCreateProj_etpInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseDeal_etpInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseFinishInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseGetPriceInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseGetPrice_etpInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseGetRev_etpInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseGetStatusInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseGetStatus_etpInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseGetTraceInfoInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseGetTraceInfo_etpInputBO;
import org.WeTender.WeTender.model.bo.EnterprisePass_etpInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseProjInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseProj_etpInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseSalary_etpInputBO;
import org.WeTender.WeTender.model.bo.EnterpriseWork_etpInputBO;
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
public class EnterpriseService {
  public static final String ABI = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("abi/Enterprise.abi");

  public static final String BINARY = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("bin/ecc/Enterprise.bin");

  public static final String SM_BINARY = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("bin/sm/Enterprise.bin");

  @Value("${system.contract.enterpriseAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public TransactionResponse Build(EnterpriseBuildInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Build", input.toArgs());
  }

  public CallResponse profit() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "profit", Arrays.asList());
  }

  public CallResponse proj(EnterpriseProjInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "proj", input.toArgs());
  }

  public TransactionResponse AfterMarket_etp(EnterpriseAfterMarket_etpInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "AfterMarket_etp", input.toArgs());
  }

  public TransactionResponse AddProj(EnterpriseAddProjInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "AddProj", input.toArgs());
  }

  public CallResponse etp_name() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "etp_name", Arrays.asList());
  }

  public TransactionResponse Pass_etp(EnterprisePass_etpInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Pass_etp", input.toArgs());
  }

  public TransactionResponse AddProfit(EnterpriseAddProfitInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "AddProfit", input.toArgs());
  }

  public CallResponse getStatus_etp(EnterpriseGetStatus_etpInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getStatus_etp", input.toArgs());
  }

  public CallResponse getStatus(EnterpriseGetStatusInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getStatus", input.toArgs());
  }

  public CallResponse getRev_etp(EnterpriseGetRev_etpInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getRev_etp", input.toArgs());
  }

  public CallResponse proj_etp(EnterpriseProj_etpInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "proj_etp", input.toArgs());
  }

  public CallResponse getTraceInfo_etp(EnterpriseGetTraceInfo_etpInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getTraceInfo_etp", input.toArgs());
  }

  public CallResponse num() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "num", Arrays.asList());
  }

  public CallResponse getPrice(EnterpriseGetPriceInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getPrice", input.toArgs());
  }

  public TransactionResponse Work_etp(EnterpriseWork_etpInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Work_etp", input.toArgs());
  }

  public TransactionResponse Deal_etp(EnterpriseDeal_etpInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Deal_etp", input.toArgs());
  }

  public TransactionResponse Finish(EnterpriseFinishInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Finish", input.toArgs());
  }

  public TransactionResponse CreateProj_etp(EnterpriseCreateProj_etpInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "CreateProj_etp", input.toArgs());
  }

  public CallResponse etp_id() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "etp_id", Arrays.asList());
  }

  public TransactionResponse Salary_etp(EnterpriseSalary_etpInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Salary_etp", input.toArgs());
  }

  public CallResponse getTraceInfo(EnterpriseGetTraceInfoInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getTraceInfo", input.toArgs());
  }

  public CallResponse getPrice_etp(EnterpriseGetPrice_etpInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getPrice_etp", input.toArgs());
  }
}
