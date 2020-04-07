package cn.gpmall.car.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gpmall.car.service.ItemAddService;
import cn.gpmall.common.mapper.AUserDao;
import cn.gpmall.common.pojo.AEvaluate;
import cn.gpmall.common.pojo.AOrder;
import cn.gpmall.common.pojo.AOrderlist;
import cn.gpmall.common.pojo.AUser;
import cn.gpmall.common.pojo.OrderAll;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.common.pojo.UserBalance;

@Service
public class ItemAddServiceImpl implements ItemAddService{
    @Autowired
    private AUserDao userDao;
	@Override
	public AUser getList1(Integer id) {
		AUser user=new AUser();
		user=userDao.getList1(id);		
		return user;
	}
	@Override
	public void getList2(UserBalance userBalance) {
		userDao.getList2(userBalance);
		
	}
	@Override
	public void getList3(UserBalance userBalance) {
		userDao.getList3(userBalance);
		
	}
	@Override
	public OrderAll getList4(Page pa) {
		List<AOrder> order=new ArrayList<AOrder>();
		//List<AOrder> list=new ArrayList<AOrder>();
		order=userDao.getList4(pa);				
		OrderAll orderAll=new OrderAll();
		Iterator it=order.iterator();
		while(it.hasNext()) { //引用的是地址，地址不变，值变
			AOrder od=(AOrder) it.next();
			
			od.getaOrderlist().setNewcreatedate("");
			//list.add(od);
		}
		orderAll.setList(order);
		return orderAll;
	}
	@Override
	public String payment(Integer userid, Integer orderid) {//去付款
		//第一步，查询拍卖的价格
		AOrder order =userDao.getByOrderListId(orderid);
		//第一步，查询用户余额是否够付款
		 int sum=userDao.checkBalance(userid,order.getPrice()); 
		 if(sum==0) {
			 return "NO";
		 }else {
			//第二步，执行付款操作，扣除用户金额，卖家金额增加
			 //1.根据订单id找到商品卖家，根据商品卖家，找到卖家加钱
			 try {
				 Integer suppid1=userDao.checkBySuppId(orderid);//找到订单卖家id
				 Integer suppid=userDao.checkBySuppId1(suppid1);//找到商品供应商
				 userDao.addMoney(suppid,order.getPrice());//卖家加钱
				 //2.卖家金额添加，买家金额减少
				 userDao.cutBack(userid,order.getPrice());//卖家减钱
				 //3.改变订单状态，状态改为3，未收货
				 userDao.changeOrder(orderid,3);
				 return "OK";
			} catch (Exception e) {
				return "fail";
			}
			
			
		 }
			
		
	}
	@Override  //收货
	public String receiving(Integer userid, Integer orderid) {
		try {
			userDao.changeOrder(orderid,4);
			 return "OK";
		} catch (Exception e) {
			return "fail";
		}		
	}
	@Override
	public String comment(Integer orderid,Integer rate,String txt) {
		// 第一步,根据订单id找到商品供应商id
		try {
			Integer suppid1=userDao.checkBySuppId(orderid);//找到订单卖家id
			 Integer suppid=userDao.checkBySuppId1(suppid1);//找到商品供应商
			 //第二步,插入评价
			 AEvaluate evaluate=new AEvaluate();
			 evaluate.setMark(rate);
			 evaluate.setComment(txt);
			 evaluate.setUserId(suppid);
			 userDao.InserEvaluate(evaluate);
			return "OK";
		} catch (Exception e) {
			return "fail";
		}
		
	}

    

   
}
