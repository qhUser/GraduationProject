package cn.gpmall.car.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gpmall.car.service.ItemAddService;
import cn.gpmall.common.pojo.AOrder;
import cn.gpmall.common.pojo.AUser;
import cn.gpmall.common.pojo.OrderAll;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.common.pojo.UserBalance;

@Controller
public class ItemAddController {
	@Autowired
	ItemAddService itemAddService;
    @RequestMapping("/")
    public String getPage() {
    	return "main";
    }
    @RequestMapping("/list1")//用户信息
    @ResponseBody
    public AUser getList1(Integer id) {   	
    	AUser user=new AUser();
    	user=itemAddService.getList1(id);
    	return user;
    }
    @RequestMapping("/list2")//用户信息
    @ResponseBody
    public String getList12(Integer id,Double money) {
    	UserBalance userBalance=new UserBalance(id,money);
    	itemAddService.getList2(userBalance);
    	return "ok";
    }
    @RequestMapping("/list3")//用户充值
    @ResponseBody
    public String getList13(Integer id,String password) {
    	UserBalance userBalance=new UserBalance(id,password);
    	itemAddService.getList3(userBalance);
    	return "ok";
    }
    @RequestMapping("/list4")//订单信息
    @ResponseBody
    public OrderAll getList14(Integer id,@RequestParam(defaultValue="1")Integer page) {
    	Page pa=new Page(page,8);
    	pa.setId(id);
    	OrderAll order=itemAddService.getList4(pa);   	
    	return order;
    }
    @RequestMapping("/payment")//去付款
    @ResponseBody
    public String  payment(Integer userid,Integer orderid) {
    	String mess=itemAddService.payment(userid,orderid);
      return mess;
    }
    @RequestMapping("/receiving")//收货
    @ResponseBody
    public String  receiving(Integer userid,Integer orderid) {
    	String mess=itemAddService.receiving(userid,orderid);
      return mess;
    }
    @RequestMapping("/comment")//评价
    @ResponseBody
    public String  comment(Integer orderid,Integer rate,String txt) {
    	String mess=itemAddService.comment(orderid,rate,txt);
      return mess;
    }
} 
