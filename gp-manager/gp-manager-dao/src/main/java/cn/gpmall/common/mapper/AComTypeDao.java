package cn.gpmall.common.mapper;

import java.util.List;

import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.AComType;
import cn.gpmall.common.pojo.APhoto;
import cn.gpmall.common.pojo.Page;

public interface AComTypeDao {

	public List<AComType> getSwitchItem();  //返回全部商品类型

	 void addCom(ACom ac);                  //用户委托商品
	 public void addCom1(ACom ac);          //企业发布商品

	public void addPhoto(APhoto photo);     //新增图片

	public List<ACom> getAccept(Page pa); //返回委托商品

	public String getDeupte(Integer deupteId);//商品中添加委托人

	public String getTypeName(Integer typeid); //获得商品类型名

	public String getPhotoUrl(Integer integer);   //查询委托图片地址

	public Integer getSum();//获得委托商品总数

	public ACom getCheck(Integer id); //获得指定委托商品

	public void getAcceptCom(Integer comid, Integer suppid);//接受委托

	
  

}
