package cn.gpmall.search.service;

import java.util.List;

import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.common.pojo.UserComment;


public interface ItemListService {
    //查询指定商品
	public List<ACom> getItemList(String keyword, Integer page);

	public Integer getSumCount(String keyword);//查询指定商品的总记录数

	public ACom getDetails(Integer id);   //查询商品详情

	public void addPrice(Integer itemid, Integer userid, Double nowprice);

	public String checkBail(Integer id);//查询用户是否缴纳保证金

	public UserComment userComment(Integer itemid);//根据商品id找到商品供应商
       
	 
}
