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
public class ProjectCtorBO {
  private BigInteger id;

  private String name;

  private BigInteger balance;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(id);
    args.add(name);
    args.add(balance);
    return args;
  }
}
