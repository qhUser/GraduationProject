package cn.gpmall.common.pojo;

import java.io.Serializable;

public class SearchItem implements Serializable{
    private String id;  //id
    private double lowestPrice;//起拍价
    private String commodityName;//商品名
    private String description;//商品描述
    private String typeName;//商品类型
    private String url;//商品图片
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
   
	public double getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    
	
}
