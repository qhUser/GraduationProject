package cn.gpmall.common.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 商品信息表
 * */
public class ACom implements Serializable{
    private Integer id;

    private String commodityname; //商品名称
 
    private Double lowestprice;   //起拍价格

    private Double nowprice;      //当前价格

    private String description;   //商品描述

    private Integer count;        //数量

    private Date satrtdate;       //起拍日期

    private Date enddate;         //结束日期
    private Double bail;           //用户是否缴纳保证金
    private Integer satus;        //商品状态：0.正在委托商品,1.未审核，2.审核未通过，3审核通过，4.已卖出，5.已下架
    private String status;        //显示给用户的商品状态
    private Boolean visable;      //是否删除，1是未删除，0是删除

    private Integer typeid;       //商品类型
  
    private Integer supplierid;   //商品供应商
    
    private Integer deupteId;     //委托方id
    
    private Integer addCount;     //加价次数
    
    private String userName;      //委托方名 表中没有
    private String suppName;      //供应商名，表中没有
    private Integer sum;          //商品的总数  表中没有
    private String typeName;       //商品类型名 表中无
    private String photoUrl;   //图片 表中没有
    private String newsatrtdate; //自定义的起拍时间 表中没有
    private String newenddate;   //自定义的结束时间 表中没有
    private int addPrice;       //最低加价单位
    //生成时间格式
   public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    
    
    public Double getBail() {
	return bail;
}

public void setBail(Double bail) {
	this.bail = bail;
}

	public Integer getAddCount() {
	return addCount;
}
    
public void setAddCount(Integer addCount) {
	this.addCount = addCount;
}
public int getAddPrice() {
	if(this.lowestprice!=null) {
		return (int) (this.lowestprice/20);
	}
	return addPrice;
}
public void setAddPrice(int addPrice) {
	this.addPrice = addPrice;
}
	public String getSuppName() {
	return suppName;
}
public void setSuppName(String suppName) {
	this.suppName = suppName;
}
	public String getTypeName() {
	return typeName;
}
public void setTypeName(String typeName) {
	this.typeName = typeName;
}
	public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
	public Integer getDeupteId() {
	return deupteId;
}
public void setDeupteId(Integer deupteId) {
	this.deupteId = deupteId;
}

	public Date getSatrtdate() {
		return satrtdate;
	}

	public void setSatrtdate(Date satrtdate) {
		this.satrtdate = satrtdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getNewsatrtdate() {
        if(this.satrtdate!=null) {
			
			return sdf.format(this.satrtdate);
		}
		return null;
	}

	public void setNewsatrtdate(String newsatrtdate) {
		if(this.satrtdate!=null) {
			
			this.newsatrtdate =sdf.format(this.satrtdate);
		}
		
	}


	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getNewenddate() {
		if(this.enddate!=null)
			return sdf.format(this.enddate);
		return null;
	}

	public void setNewenddate(String newenddate) {
		if(this.enddate!=null)
		this.newenddate = sdf.format(this.enddate);
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname == null ? null : commodityname.trim();
    }

    public Double getLowestprice() {
        return lowestprice;
    }

    public void setLowestprice(Double lowestprice) {
        this.lowestprice = lowestprice;
    }

    public Double getNowprice() {
        return nowprice;
    }

    public void setNowprice(Double nowprice) {
        this.nowprice = nowprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Integer getSatus() {
        return satus;
    }

    public void setSatus(Integer satus) {
        this.satus = satus;
    }

    
    //商品状态：0.正在委托商品,1.未审核，2.审核未通过，3审核通过，4.已卖出，5.已下架
    public String getStatus() {
    	if(this.getSatus()!=null&&this.getSatus()==0)
		return "正在委托";
    	if(this.getSatus()!=null&&this.getSatus()==1)
    		return "未审核";
    	if(this.getSatus()!=null&&this.getSatus()==2)
    		return "审核未通过";
    	if(this.getSatus()!=null&&this.getSatus()==3)
    		return "审核通过";
    	if(this.getSatus()!=null&&this.getSatus()==4)
    		return "已卖出";
    	if(this.getSatus()!=null&&this.getSatus()==5)
    		return "已下架";
    	return "";
	}
	public void setStatus(String status) {
		
	}
	public Boolean getVisable() {
        return visable;
    }

    public void setVisable(Boolean visable) {
        this.visable = visable;
    }

	public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

	@Override
	public String toString() {
		return "ACom [id=" + id + ", commodityname=" + commodityname + ", lowestprice=" + lowestprice + ", nowprice="
				+ nowprice + ", description=" + description + ", count=" + count + ", satrtdate=" + satrtdate
				+ ", enddate=" + enddate + ", satus=" + satus + ", visable=" + visable + ",  typeid="
				+ typeid + ", supplierid=" + supplierid + ", sum=" + sum + ", newsatrtdate=" + newsatrtdate
				+ ", newenddate=" + newenddate + "]";
	}



    
}