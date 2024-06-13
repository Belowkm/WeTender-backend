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
public class EnterpriseGetStatus_etpInputBO {
  private BigInteger ProjectID_etp;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(ProjectID_etp);
    return args;
  }
}
