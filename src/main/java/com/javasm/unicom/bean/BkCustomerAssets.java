package com.javasm.unicom.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BkCustomerAssets {
   //证券市值
   private Integer customerId;//主键
   private Integer userId;//客户ID
   private Integer coBusinessId;//企业Id，用户持股票公司Id
   private Integer holdNumber;//持有数量  1手=100股
   private Float holdMoney;//成本价格，买入时每股单价
   private Integer state;//状态  1：可用  0：删除




}
