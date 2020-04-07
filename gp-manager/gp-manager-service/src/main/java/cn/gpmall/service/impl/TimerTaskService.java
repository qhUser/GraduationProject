package cn.gpmall.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;
import cn.gpmall.common.mapper.AComDao;
import cn.gpmall.common.mapper.OrderDao;
import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.AOrder;

public class TimerTaskService extends TimerTask{
	private AComDao comDao;
	private OrderDao orderDao;
	 public TimerTaskService(AComDao comDao,OrderDao orderDao) {
		 this.comDao=comDao;
		 this.orderDao=orderDao;
	}
	public void run() {
		//第一步，查询数据库，判定是否有商品到拍卖时间
		List<ACom> aCom=excute();//执行查询拍卖期限到的商品id
		if(aCom==null||aCom.size()==0)
			return;
		//第二步,根据查询到的商品id，查找与商品信息所有的订单.
		Iterator it=aCom.iterator();
		  while(it.hasNext()) {
		//Integer isok;交易状态:1竞拍成功，未竞拍得该商品,2竞拍成功，以竞拍得该商品,3竞拍成功，但未付款，4竞拍成功并成功付款，但未收货，5.已成功收货
		//第三步,找出订单中出价最高的订单状态,将状态改为2,将其他订单状态改为1
			  ACom ac=new ACom();
			  ac=(ACom) it.next();				  
			  List<AOrder> aOrder=excuteByOrder(ac.getId());//找到了所有有关该商品的id		
			  if(aOrder==null||aOrder.size()==0)
				  return;
			  //对所有订单进行遍历，找出出价最高的那一张订单
			  Iterator itOrder=aOrder.iterator();
			  Integer UserId=null;//订单详情id
			  Double MaxPrice=null;//最高价格
			  while(itOrder.hasNext()) {
				  AOrder aO=(AOrder) itOrder.next();
				  if(UserId==null) {
					  UserId=aO.getOrderlistid();
				  }
				  if(MaxPrice==null) {
					  MaxPrice=aO.getPrice();
				  }else {
					  Double nowPrice=aO.getPrice();
					  if(nowPrice>MaxPrice) {
						  MaxPrice=nowPrice;
						  UserId=aO.getOrderlistid();
					  }
				  }  
			  }//遍历订单结束			
			  if(UserId!=null) {//将出价最高的订单编号状态改为2
				  orderDao.auctionOK(UserId,2);
				//第四步，改变商品状态，将商品状态改为已卖出或已下架,4.已卖出，5.已下架
				  comDao.status(ac.getId(),4);
			  }else {
				  //将商品状态改为已下架。
				  comDao.status(ac.getId(),5);
			  }
			  
	      }//遍历拍卖过期商品结束
		//第五步,根据商品id在solr中下架
		
	}	
	private List<AOrder> excuteByOrder(Integer id) {
		List<AOrder> aOrder=this.orderDao.excuteByOrder(id);
		return aOrder;
	}
	public List<ACom> excute() {
		List<ACom> aCom= this.comDao.equalsTime();//查询所有拍卖期限过后的商品。		  
		  return aCom;
	}
	public AComDao getComDao() {
		return comDao;
	}
	public void setComDao(AComDao comDao) {
		this.comDao = comDao;
	}
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
   
}
