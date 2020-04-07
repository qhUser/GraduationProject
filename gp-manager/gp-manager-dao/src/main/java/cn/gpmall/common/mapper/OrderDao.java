package cn.gpmall.common.mapper;

import java.util.List;

import cn.gpmall.common.pojo.AOrder;
import cn.gpmall.common.pojo.AOrderlist;

public interface OrderDao {

	void addOrder(AOrderlist order);//生成订单，返回主键

	void addOrderCom(Integer itemid, Integer id, Double nowprice);//生成订单-商品表

	List<AOrder> excuteByOrder(Integer id);//根据商品id查询所有与该商品有关的订单订单

	void auctionOK(Integer userId, int i);//将出价最高的订单状态改为2;

}
