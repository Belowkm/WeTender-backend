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
public class County_GovGetTraceInfoInputBO {
  private BigInteger ProjectID;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(ProjectID);
    return args;
  }
}
