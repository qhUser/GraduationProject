package cn.gpmall.search.service.impl;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gpmall.common.mapper.AComDao;
import cn.gpmall.common.mapper.OrderDao;
import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.AEvaluate;
import cn.gpmall.common.pojo.AOrderlist;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.common.pojo.UserComment;
import cn.gpmall.search.service.ItemListService;

@Service
public class ItemListServiceImpl implements ItemListService {
    @Autowired
    private AComDao acomDao;
    @Autowired
    private OrderDao orderDao;
	@Override
	public List<ACom> getItemList(String keyword, Integer page) {
		Page pa=new Page(page,8);
		pa.setKeyword(keyword);
		List<ACom> list=acomDao.getItemList(pa);
		Iterator it=list.iterator();
		while(it.hasNext()) {
			ACom ac=(ACom) it.next();
			Integer id=ac.getId();
			String photo=acomDao.getUrl(id);
			
			ac.setPhotoUrl(photo);
		}
		return list;
	}		
	@Override
	public Integer getSumCount(String keyword) {
		int count=acomDao.getSumCount(keyword);
		return count;
	}
	@Override
	public ACom getDetails(Integer id) {  //查询商品详情		
		ACom ac=new ACom();
		ac=acomDao.getDetails(id);
		String url=acomDao.getUrl(id);
		ac.setPhotoUrl(url);
		return ac;
	}
	@Override//加价
	public void addPrice(Integer itemid, Integer userid, Double nowprice) {
		//第一步：更改商品当前价格，商品id,当前价格
		acomDao.addPrice(itemid,nowprice);
		//第二步:生成订单表:传入用户信息，返回订单编号
		AOrderlist order=new AOrderlist();
		Date date=new Date();
		order.setCreatedate(date);
		order.setUserid(userid);
		orderDao.addOrder(order); //返回了订单编号
		//第三步：生成订单-商品表 传入商品id，订单id,和商品价格
		orderDao.addOrderCom(itemid,order.getId(),nowprice);	
	}
	@Override           //缴纳保证金
	public String checkBail(Integer id) {
		//第一步，判定余额是否够
		Double money= acomDao.checkMoney(id);
		//第二步，缴纳保证金
		if(money>=200) {
			try {				
				acomDao.checkBail(id);
				return "OK";
			} catch (Exception e) {
				return "NoMoney";
			}			
		}else {
			return "NoMoney";
		}
		
	}
	@Override
	public UserComment userComment(Integer itemid) {
		//第一步,找到商品供应商
		Integer suppId=acomDao.getUserById(itemid);
		String name=acomDao.getUserName(suppId);
		//第二步,根据商品供应商id，找到所有对应的评价表
		List<AEvaluate> list=acomDao.getEvaluate(suppId);//根据供应商id，找到对应的评价表
		//第三步,将所有评价表内容的评分取出来，求平均值
		Iterator it=list.iterator();
		int sum=0;  //总分
		double aver;
		DecimalFormat df=new DecimalFormat("#.0");//限制小数一位
		while(it.hasNext()) {
			AEvaluate evaluate=new AEvaluate();
			evaluate=(AEvaluate) it.next();
			sum+=evaluate.getMark();
	
		}
		double i=list.size();
		aver=sum/i;//获得平均分
		String average=df.format(aver);
		UserComment userComment=new UserComment();
		userComment.setAverager(average);
		userComment.setList(list);
		userComment.setUserName(name);
		return userComment;
	}

}
