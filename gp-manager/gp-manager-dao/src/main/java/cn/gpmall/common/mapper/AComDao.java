package cn.gpmall.common.mapper;

import java.util.Date;
import java.util.List;

import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.AEvaluate;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.common.pojo.SearchItem;

public interface AComDao {
	
	public List<ACom> getAll(Page page);//获得全部上架商品分页查询	
	public List<ACom> getAdd(Page pag);//获得未审核商品
	public Integer getSum3();          //或的审核通过商品数量
	public Integer getSum1();           //获得未审核商品数量
	public void getAdopt(Integer id);   //审核通过操作
	public void getNoPass(Integer id);  //审核不通过操作
	public List<ACom> getNew();  //获得新上架的商品
	public List<ACom> getonSale(Date date); //获得正在上架的商品
	public List<ACom> getItemList(Page pa);//获得查询的商品
	public int getSumCount(String keyword);//获得指定查询商品的总记录数
	public String getUrl(Integer id);//获得指定id的照片
	public List<SearchItem> getComAll();//获得全部上架商品全部，solr索引库添加
	public SearchItem getItemById(Integer itemId);//根据商品id，同步到索引库
	public ACom getDetails(Integer id);//查询商品详情
	public void addPrice(Integer itemid,  Double nowprice); //商品加价
	public List<ACom> equalsTime();//根据当前时间查询数据库中所有拍卖期限到的商品信息
	public void status(Integer id, Integer i);//根据商品id，改变商品状态
	public Double checkBail(Integer id);//用户提交保证金
	public Double checkMoney(Integer id);//判断用户账户余额是否够，
	public Integer getUserById(Integer itemid);//根据商品id找到商品供应商
	public List<AEvaluate> getEvaluate(Integer suppId);//根据供应商id找到对应的评价表
	public String getUserName(Integer suppId);//找到用户名
	
}
