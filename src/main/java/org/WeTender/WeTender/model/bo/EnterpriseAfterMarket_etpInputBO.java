package org.WeTender.WeTender.model.bo;

import java.lang.Object;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseAfterMarket_etpInputBO {
  private BigInteger ProjectID_etp;

  private BigInteger money;

  private String remark;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(ProjectID_etp);
    args.add(money);
    args.add(remark);
    return args;
  }
}
