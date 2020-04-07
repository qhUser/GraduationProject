package cn.gpmall.common.pojo;

import java.io.Serializable;
import java.util.List;

public class EasyUIData implements Serializable{
      private Integer total; //总页数
      private List rows; //总记录
     
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}

      
      
}
