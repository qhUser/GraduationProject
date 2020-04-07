package cn.gpmall.service.impl;

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

import cn.gpmall.common.mapper.AComDao;
import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.EasyUIData;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService{
	     @Autowired
		private JmsTemplate jmsTemplate;
		@Resource
		private Destination topicDestination;
	    
	    @Autowired
        private AComDao aComDao;//获得已通过审核商品
		public EasyUIData getPage(Integer page, Integer count) {
		    Page pag=new Page(page,count);
			List<ACom> row=aComDao.getAll(pag);
			List<ACom> rows=new ArrayList<ACom>();
			Iterator<ACom> it=row.iterator();
			while(it.hasNext()) {
				ACom ac=it.next();
				ac.setNewsatrtdate("");
				ac.setNewenddate("");				
				rows.add(ac);
			}	
			EasyUIData result=new EasyUIData();		
			result.setRows(rows);
			Integer sum=aComDao.getSum3();
			result.setTotal(sum);
			return result;
		}
		@Override//获得未审核商品
		public EasyUIData getAdd(Integer page, Integer count) {
			   Page pag=new Page(page,count);
				List<ACom> rows=aComDao.getAdd(pag);	
				EasyUIData result=new EasyUIData();		
				result.setRows(rows);
				Integer sum=aComDao.getSum1();
				result.setTotal(sum);
				return result;
		}
		
		@Override//获得新上架的商品
		public List<ACom> getNew() {
			List<ACom> list=aComDao.getNew();	
			Iterator it=list.iterator();
			while(it.hasNext()) {
				ACom ac=(ACom) it.next();
				Integer id=ac.getId();
				String photo=aComDao.getUrl(id);
				
				ac.setPhotoUrl(photo);
			}
			return list;
		}
		
		@Override//审核商品通过
		public void getAdopt(Integer id) {
			aComDao.getAdopt(id);
			final int itemId=id;//传入内部类要常量
			//发送商品添加消息
					jmsTemplate.send(topicDestination, new MessageCreator() {	
						@Override
						public Message createMessage(Session session) throws JMSException {
							TextMessage textMessage = session.createTextMessage(itemId+"");
							System.out.println("发送消息");
							return textMessage;
						}
					});
		}
		@Override//未通过审核商品
		public void getNoPass(Integer id) {
			aComDao.getNoPass(id);
			
		}
		@Override//获得正在拍卖的商品
		public List<ACom> getonSale() {
			Date date=new Date();
			 List<ACom> list= aComDao.getonSale(date);
			 System.out.println(list);
			return list;
		}
		@Override
		public List<ACom> equalsTime() {
			List<ACom> aCom= aComDao.equalsTime();//查询所有拍卖期限过后的商品。
			  Iterator it=aCom.iterator();
			  while(it.hasNext()) {
				  ACom ac=new ACom();
				  ac=(ACom) it.next();
				  ac.toString();
		}
			  return aCom;
		}
}
