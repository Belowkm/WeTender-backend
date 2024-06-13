package org.WeTender.WeTender.model.bo;

import java.lang.Object;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseAddProfitInputBO {
  private BigInteger ProjectID;

  private BigInteger money;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(ProjectID);
    args.add(money);
    return args;
  }
}
