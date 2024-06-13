package org.WeTender.WeTender.config;

import java.lang.String;
import lombok.Data;

@Data
public class ContractConfig {
  private String tableAddress;

  private String governmentAddress;

  private String projectAddress;

  private String bankAddress;

  private String enterpriseAddress;

  private String county_GovAddress;

  private String town_GovAddress;
}
