package org.WeTender.WeTender.service;

import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.WeTender.WeTender.config.SystemConfig;
import org.fisco.bcos.sdk.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@Slf4j
public class ServiceManager {
  @Autowired
  private SystemConfig config;

  @Autowired
  private Client client;

  List<String> hexPrivateKeyList;

  @PostConstruct
  public void init() {
    hexPrivateKeyList = Arrays.asList(this.config.getHexPrivateKey().split(","));
  }

  /**
   * @notice: must use @Qualifier("Town_GovService") with @Autowired to get this Bean
   */
  @Bean("Town_GovService")
  public Map<String, Town_GovService> initTown_GovServiceManager() throws Exception {
    Map<String, Town_GovService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	Town_GovService town_GovService = new Town_GovService();
    	town_GovService.setAddress(this.config.getContract().getTown_GovAddress());
    	town_GovService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	town_GovService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, town_GovService);
    }
    log.info("++++++++Town_GovService map:{}", serviceMap);
    return serviceMap;
  }

  /**
   * @notice: must use @Qualifier("TableService") with @Autowired to get this Bean
   */
  @Bean("TableService")
  public Map<String, TableService> initTableServiceManager() throws Exception {
    Map<String, TableService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	TableService tableService = new TableService();
    	tableService.setAddress(this.config.getContract().getTableAddress());
    	tableService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	tableService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, tableService);
    }
    log.info("++++++++TableService map:{}", serviceMap);
    return serviceMap;
  }

  /**
   * @notice: must use @Qualifier("ProjectService") with @Autowired to get this Bean
   */
  @Bean("ProjectService")
  public Map<String, ProjectService> initProjectServiceManager() throws Exception {
    Map<String, ProjectService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	ProjectService projectService = new ProjectService();
    	projectService.setAddress(this.config.getContract().getProjectAddress());
    	projectService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	projectService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, projectService);
    }
    log.info("++++++++ProjectService map:{}", serviceMap);
    return serviceMap;
  }

  /**
   * @notice: must use @Qualifier("GovernmentService") with @Autowired to get this Bean
   */
  @Bean("GovernmentService")
  public Map<String, GovernmentService> initGovernmentServiceManager() throws Exception {
    Map<String, GovernmentService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	GovernmentService governmentService = new GovernmentService();
    	governmentService.setAddress(this.config.getContract().getGovernmentAddress());
    	governmentService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	governmentService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, governmentService);
    }
    log.info("++++++++GovernmentService map:{}", serviceMap);
    return serviceMap;
  }

  /**
   * @notice: must use @Qualifier("EnterpriseService") with @Autowired to get this Bean
   */
  @Bean("EnterpriseService")
  public Map<String, EnterpriseService> initEnterpriseServiceManager() throws Exception {
    Map<String, EnterpriseService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	EnterpriseService enterpriseService = new EnterpriseService();
    	enterpriseService.setAddress(this.config.getContract().getEnterpriseAddress());
    	enterpriseService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	enterpriseService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, enterpriseService);
    }
    log.info("++++++++EnterpriseService map:{}", serviceMap);
    return serviceMap;
  }

  /**
   * @notice: must use @Qualifier("County_GovService") with @Autowired to get this Bean
   */
  @Bean("County_GovService")
  public Map<String, County_GovService> initCounty_GovServiceManager() throws Exception {
    Map<String, County_GovService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	County_GovService county_GovService = new County_GovService();
    	county_GovService.setAddress(this.config.getContract().getCounty_GovAddress());
    	county_GovService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	county_GovService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, county_GovService);
    }
    log.info("++++++++County_GovService map:{}", serviceMap);
    return serviceMap;
  }

  /**
   * @notice: must use @Qualifier("BankService") with @Autowired to get this Bean
   */
  @Bean("BankService")
  public Map<String, BankService> initBankServiceManager() throws Exception {
    Map<String, BankService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	BankService bankService = new BankService();
    	bankService.setAddress(this.config.getContract().getBankAddress());
    	bankService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	bankService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, bankService);
    }
    log.info("++++++++BankService map:{}", serviceMap);
    return serviceMap;
  }
}
