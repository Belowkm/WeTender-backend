package org.WeTender.WeTender.service;

import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.WeTender.WeTender.model.bo.ProjectAfterMarketInputBO;
import org.WeTender.WeTender.model.bo.ProjectBuildInputBO;
import org.WeTender.WeTender.model.bo.ProjectDealInputBO;
import org.WeTender.WeTender.model.bo.ProjectFinishInputBO;
import org.WeTender.WeTender.model.bo.ProjectPassInputBO;
import org.WeTender.WeTender.model.bo.ProjectSalaryInputBO;
import org.WeTender.WeTender.model.bo.ProjectTraceDataInputBO;
import org.WeTender.WeTender.model.bo.ProjectWorkInputBO;
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
public class ProjectService {
  public static final String ABI = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("abi/Project.abi");

  public static final String BINARY = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("bin/ecc/Project.bin");

  public static final String SM_BINARY = org.WeTender.WeTender.utils.IOUtil.readResourceAsString("bin/sm/Project.bin");

  @Value("${system.contract.projectAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public CallResponse owner() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "owner", Arrays.asList());
  }

  public CallResponse ProjectId() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "ProjectId", Arrays.asList());
  }

  public CallResponse ProjectName() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "ProjectName", Arrays.asList());
  }

  public TransactionResponse Finish(ProjectFinishInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Finish", input.toArgs());
  }

  public TransactionResponse AfterMarket(ProjectAfterMarketInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "AfterMarket", input.toArgs());
  }

  public TransactionResponse Salary(ProjectSalaryInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Salary", input.toArgs());
  }

  public CallResponse getRev() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getRev", Arrays.asList());
  }

  public CallResponse getTraceInfo() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getTraceInfo", Arrays.asList());
  }

  public CallResponse bal() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "bal", Arrays.asList());
  }

  public CallResponse getPrice() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getPrice", Arrays.asList());
  }

  public TransactionResponse Deal(ProjectDealInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Deal", input.toArgs());
  }

  public TransactionResponse Pass(ProjectPassInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Pass", input.toArgs());
  }

  public TransactionResponse Build(ProjectBuildInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Build", input.toArgs());
  }

  public CallResponse getStatus() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getStatus", Arrays.asList());
  }

  public CallResponse _status() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "_status", Arrays.asList());
  }

  public TransactionResponse Work(ProjectWorkInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "Work", input.toArgs());
  }

  public CallResponse traceData(ProjectTraceDataInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "traceData", input.toArgs());
  }

  public CallResponse builder() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "builder", Arrays.asList());
  }
}
