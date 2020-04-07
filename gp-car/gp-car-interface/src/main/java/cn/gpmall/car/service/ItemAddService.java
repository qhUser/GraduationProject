package cn.gpmall.car.service;
import java.util.List;
import cn.gpmall.common.pojo.AUser;
import cn.gpmall.common.pojo.OrderAll;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.common.pojo.UserBalance;

public interface ItemAddService {
  public AUser getList1(Integer id);//用户查看基本信息

  public void getList2(UserBalance userBalance);//用户充值

  public void getList3(UserBalance userBalance);//用户修改密码

  public OrderAll getList4(Page pa);//用户查询订单

   public String payment(Integer userid, Integer orderid);//去付款

public String receiving(Integer userid, Integer orderid);//去收货

public String comment(Integer orderid,Integer rate,String txt);//评价
}
