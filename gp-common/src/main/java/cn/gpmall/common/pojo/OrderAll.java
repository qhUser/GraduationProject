package cn.gpmall.common.pojo;

import java.io.Serializable;
import java.util.List;

public class OrderAll implements Serializable{
    private List list;
    private Page page;

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
    
}
