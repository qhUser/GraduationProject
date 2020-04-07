package cn.gpmall.search.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gpmall.common.mapper.AComDao;
import cn.gpmall.common.pojo.SearchItem;
import cn.gpmall.search.service.ItemSolrService;
@Service
public class ItemSolrServiceImpl implements ItemSolrService{
    @Autowired
    AComDao aCom;
    @Autowired
    private SolrServer solrServer;
    /**
     * 同步商品到索引库
     * */
	public String searchItem() {
		try {
			List<SearchItem> search=new ArrayList<SearchItem>();
			search=aCom.getComAll();
			for(SearchItem s:search) {
				//创建文档对象
				SolrInputDocument document=new SolrInputDocument();
				//向文档对象中添加域
				document.addField("id", s.getId());
				document.addField("com_title",s.getCommodityName());
				document.addField("com_sell_point", s.getDescription());
				document.addField("com_price", s.getLowestPrice());
				document.addField("com_image", s.getUrl());
				document.addField("com_category_name", s.getTypeName());
				solrServer.add(document);		
			}
			solrServer.commit();
			return "ok";
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		
	}

}
