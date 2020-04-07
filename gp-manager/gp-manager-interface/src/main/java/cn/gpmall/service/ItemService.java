package cn.gpmall.service;

import java.util.List;

import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.EasyUIData;

public interface ItemService {
	/*
	 * 查询商品
	 * */
	public EasyUIData getPage(Integer page,Integer rows);
    
	/*
	 * 审核商品
	 * */
	public EasyUIData getAdd(Integer page, Integer rows);
    
	/**
	 * 审查商品通过
	 * @return 
	 * */
	public void getAdopt(Integer id);
   
	public void getNoPass(Integer id);//审核不通过
	public List<ACom> getNew(); //获得新上架的商品

	public List<ACom> getonSale();//获得当前拍卖的商品

	public List<ACom> equalsTime();//监听商品
}
