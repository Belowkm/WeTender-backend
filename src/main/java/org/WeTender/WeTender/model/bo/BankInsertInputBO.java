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
public class BankInsertInputBO {
  private BigInteger ProjectID;

  private String Sender;

  private String Receiver;

  private BigInteger money;

  private BigInteger Timestamp;

  private String TransferID;

  private String remark;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(ProjectID);
    args.add(Sender);
    args.add(Receiver);
    args.add(money);
    args.add(Timestamp);
    args.add(TransferID);
    args.add(remark);
    return args;
  }
}
