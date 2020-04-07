package cn.gpmall.car.service;

import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.ComTypeAll;
import cn.gpmall.common.pojo.OrderAll;
import cn.gpmall.common.pojo.Page;

public interface UserDeputeService {

	ComTypeAll getSwitchItem();

	void addItem(String url, Integer swit, String comName, String startDate, String endDate, Double lastprice,
			Integer count, String descript, Integer id, Integer level);//增加商品

	OrderAll getAccept(Page pa);   //委托商品

	Integer getSum();//获得委托商品总数

	ACom getCheck(Integer id);//获得指定委托商品

	void getAcceptCom(Integer comid, Integer suppid);//接受委托商品
	

}
