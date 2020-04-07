package cn.gpmall.search.message;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import cn.gpmall.common.mapper.AComDao;
import cn.gpmall.common.pojo.SearchItem;

/**
 * 监听商品添加消息，接收消息后，将对应的商品信息同步到索引库
 * <p>Title: ItemAddMessageListener</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
public class ItemAddMessageListener implements MessageListener {
	
	@Autowired
	private AComDao aComDao;
	@Autowired
	private SolrServer solrServer;

	@Override
	public void onMessage(Message message) {
		try {
			//从消息中取商品id
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			Integer itemId = new Integer(text);
			//等待事务提交
			Thread.sleep(1000);
			//根据商品id查询商品信息
			SearchItem searchItem = aComDao.getItemById(itemId);
			//创建一个文档对象
			SolrInputDocument document = new SolrInputDocument();
			//向文档对象中添加域
			document.addField("id", searchItem.getId());
			document.addField("com_title", searchItem.getCommodityName());
			document.addField("com_sell_point", searchItem.getDescription());
			document.addField("com_price", searchItem.getLowestPrice());
			document.addField("com_image", searchItem.getUrl());
			document.addField("com_category_name", searchItem.getTypeName());
			//把文档写入索引库
			solrServer.add(document);
			//提交
			solrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
