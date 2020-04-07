package cn.gpmall.controller;

import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.gpmall.common.pojo.ACom;
import cn.gpmall.service.ItemService;
@Controller
public class TimerTaskController extends TimerTask{
	
	private ItemService itemService;
	public void run() {
		excute();
	}	
	public void excute() {
		List<ACom> aCom= this.itemService.equalsTime();//查询所有拍卖期限过后的商品。
		  Iterator it=aCom.iterator();
		  while(it.hasNext()) {
			  ACom ac=new ACom();
			  ac=(ACom) it.next();
			  ac.toString();
	}
	}
	public ItemService getItemService() {
		return itemService;
	}
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
}
