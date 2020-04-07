package cn.gpmall.car.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import cn.gpmall.car.service.UserDeputeService;
import cn.gpmall.common.mapper.AComTypeDao;
import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.AComType;
import cn.gpmall.common.pojo.APhoto;
import cn.gpmall.common.pojo.ComTypeAll;
import cn.gpmall.common.pojo.OrderAll;
import cn.gpmall.common.pojo.Page;

@Service
public class UserDeputeServiceImpl implements UserDeputeService{
    @Autowired
    AComTypeDao aComType;
    @Autowired
	private JmsTemplate jmsTemplate;
	@Resource
	private Destination topicDestination;
	@Override
	public ComTypeAll getSwitchItem() { //获得全部商品类型
	    ComTypeAll comType=new ComTypeAll();
	    List<AComType> com=new ArrayList<AComType>();
	    Iterator it=com.iterator();	
	    com=aComType.getSwitchItem();
	    comType.setList(com);
		return comType;
	}
	@Override
	public void addItem(String url, Integer swit, String comName, String startDate, String endDate, Double lastprice,
			Integer count, String descript, Integer id,Integer level) {//新增商品
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date startdate=new Date();
		Date enddate=new Date();
		try {
			startdate=sdf.parse(startDate);
			enddate=sdf.parse(endDate);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		APhoto photo=new APhoto();
		photo.setUrl(url);//存放图片地址
		ACom ac=new ACom(); //商品
		ac.setCommodityname(comName);
		ac.setCount(count);
		ac.setSatrtdate(startdate);
		ac.setEnddate(enddate);
		ac.setLowestprice(lastprice);
		ac.setNowprice(lastprice);
		ac.setDescription(descript);
		ac.setSatus(0);//委托拍卖商品
		ac.setVisable(true);
        ac.setTypeid(swit);
        ac.setDeupteId(id);
        if(level==1) {//如果用户级别为1，设置拍卖委托
        	aComType.addCom(ac);
        }else {//如果是企业用户，设置拍卖发布
        	aComType.addCom1(ac);
        }
		
		//System.out.println(ac.getId());
		photo.setObjId(ac.getId());
		aComType.addPhoto(photo);
//		final int itemId=ac.getId();//传入内部类要常量
//		//发送商品添加消息
//				jmsTemplate.send(topicDestination, new MessageCreator() {
//					
//					@Override
//					public Message createMessage(Session session) throws JMSException {
//						TextMessage textMessage = session.createTextMessage(itemId+"");
//						System.out.println("发送消息");
//						return textMessage;
//					}
//				});
	}
	@Override
	public OrderAll getAccept(Page pa) {		//返回的是委托商品
		List<ACom> com=new ArrayList<ACom>();
		OrderAll order=new OrderAll();
		com=aComType.getAccept(pa);
		Iterator it=com.iterator();
		while(it.hasNext()) {//迭代，添加委托人，商品类型
			ACom ac=(ACom) it.next();
			APhoto photo=new APhoto();
			photo.setObjId(ac.getId());
			ac.setUserName(aComType.getDeupte(ac.getDeupteId()));   //添加委托人
			ac.setTypeName(aComType.getTypeName(ac.getTypeid()));   //获得商品类型
			ac.setPhotoUrl(aComType.getPhotoUrl(photo.getObjId())); //获得图片地址		
			
		}
		
		order.setList(com);	
		order.setPage(pa);
		return order;
	}
	@Override
	public Integer getSum() {
		Integer sum=aComType.getSum();
		return sum;
	}
	@Override
	public ACom getCheck(Integer id) {// 获得指定查询的商品
		ACom ac=new ACom();
		ac=aComType.getCheck(id);
		APhoto photo=new APhoto();
		photo.setObjId(ac.getId());
		ac.setUserName(aComType.getDeupte(ac.getDeupteId()));   //添加委托人
		ac.setTypeName(aComType.getTypeName(ac.getTypeid()));   //获得商品类型
		ac.setPhotoUrl(aComType.getPhotoUrl(photo.getObjId())); //获得图片地址		
		return ac;
	}
	@Override
	public void getAcceptCom(Integer comid, Integer suppid) {
		aComType.getAcceptCom(comid,suppid);
		
	}

}
