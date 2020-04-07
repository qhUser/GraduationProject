package cn.gpmall.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.gpmall.common.pojo.Page;
import cn.gpmall.search.dao.SearchDao;
import cn.gpmall.search.service.SearchService;
@Controller
public class SearchServiceImpl implements SearchService{
    @Autowired
    private SearchDao serchDao;
    /**
     * 
     * solr查询商品
     * */
	@Override
	public Page search(String keyword, Integer page,Integer rows) throws Exception{
		//创建一个SolrQuery对象		
		SolrQuery query = new SolrQuery();
		//设置查询条件
        if(keyword==null||keyword.trim().equals("")) {
        	
        	query.setQuery("*");
		}else {
			
			query.setQuery(keyword);
		}		
		//设置分页条件
		if (page <=0 ) page =1;
		query.setStart((page - 1) * rows);
		query.setRows(rows);
		//设置默认搜索域
		query.set("df", "com_keywords");
		//开启高亮显示
		query.setHighlight(true);
		query.addHighlightField("com_keywords");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		//调用dao执行查询
		Page pa=serchDao.search(query);	
		pa.setCount(rows);
		pa.setPage(page);
		pa.setKeyword(keyword);
		return pa;
	}
   
}
