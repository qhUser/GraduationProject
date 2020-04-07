package cn.gpmall.common.pojo;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable{
     private Integer page; //当前页数 从1开始
     private Integer count;//一页数
     private Integer nowCount;//起始条数
     private List list;       
     private Integer sum;  //总记录数
     private Integer sumPage;  //总页数
     
     private String keyword; //查询值
     private Integer id; //查询的id
     public Page() {
    	 
     }
     public Page(Integer page,Integer count) {
    	 if(page<=0)
    		 page=1;
    	 this.page=page;
    	 this.count=count;
    	 if(this.page!=null&&this.count!=null) {
    		 this.nowCount=(this.page-1)*this.count;
    	 }
     }
     
     
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public Integer getSumPage() {
		if(sum!=null) {
			return (this.sum-1)/this.count+1;
		}
		return sumPage;
	}
	public void setSumPage(Integer sumPage) {
		this.sumPage = sumPage;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getNowCount() {
		if(this.page!=null&&this.count!=null) {
   		 return (this.page-1)*this.count;
   	    }
		return nowCount;
	}
	public void setNowCount(Integer nowCount) {
		this.nowCount = nowCount;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
     
}
