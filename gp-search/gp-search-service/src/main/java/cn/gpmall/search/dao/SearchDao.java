package cn.gpmall.search.dao;

import java.util.*;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.gpmall.common.pojo.Page;
import cn.gpmall.common.pojo.SearchItem;

@Repository
public class SearchDao {
  @Autowired
  private SolrServer solrServer;
  /**
   * 根据查询条件查询索引库
   * */
  public Page search(SolrQuery query) throws Exception{
	        //根据query查询索引库
			QueryResponse queryResponse = solrServer.query(query);
			//取查询结果。
			SolrDocumentList solrDocumentList = queryResponse.getResults();
			//取查询结果总记录数
			long numFound = solrDocumentList.getNumFound();
			Page pa=new Page();
			pa.setSum((int)numFound);
			//取商品列表，需要取高亮显示
			Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
			List<SearchItem> itemList = new ArrayList<>();
			for(SolrDocument solrDocument:solrDocumentList) {
				SearchItem item = new SearchItem();
				item.setId((String)solrDocument.get("id"));
				item.setTypeName((String)solrDocument.get("com_category_name"));
			    item.setDescription((String)solrDocument.get("com_sell_point"));
			    item.setUrl((String)solrDocument.get("com_image"));
			    item.setLowestPrice((double)solrDocument.get("com_price"));
			    //取高亮显示
			    List<String> list = highlighting.get(solrDocument.get("id")).get("com_title");
			    String title = "";
			    if (list != null && list.size() > 0) {
					title = list.get(0);
				} else {
					title = (String) solrDocument.get("com_title");
				}
			    item.setCommodityName(title);
			    //添加到商品列表
			    itemList.add(item);
			}
			pa.setList(itemList);
			return pa;
  }
}
