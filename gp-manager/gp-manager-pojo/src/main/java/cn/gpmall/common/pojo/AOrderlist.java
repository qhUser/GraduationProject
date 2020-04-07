package cn.gpmall.common.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 订单详情表
 * */
public class AOrderlist implements Serializable{
    private Integer id;   //订单编号

    private Integer userid;  //用户id

    private Date createdate; //订单生成日期

    private Integer isok;   //交易状态:1竞拍成功，未竞拍得该商品,2竞拍成功，但未付款，3竞拍成功并成功付款，但未收货，4.已成功收货 5违约
  
    private Boolean visable;  //订单是否可见
    private String newcreatedate;  //放回格式的日期
    private String status;   //订单显示状态，表中没有
  //生成时间格式
    public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public Integer getId() {
        return id;
    }

   

	public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
    
        this.createdate = createdate;
    }
    public String getNewcreatedate() {
		return newcreatedate;
	}

	public void setNewcreatedate(String newcreatedate) {
		if(this.createdate!=null) {
			this.newcreatedate=sdf.format(this.getCreatedate());
		}
	}
    public Integer getIsok() {
		return isok;
	}

	public void setIsok(Integer isok) {
		this.isok = isok;
	}

	public Boolean getVisable() {
        return visable;
    }

    public void setVisable(Boolean visable) {
        this.visable = visable;
    }
    public String getStatus() {
		if(this.getIsok()!=null&&this.getIsok()==2)
		return "等待付款";
		if(this.getIsok()!=null&&this.getIsok()==3)
			return "未收货";
		if(this.getIsok()!=null&&this.getIsok()==4)
			return "已收货";
		return "未成交";
	}

	public void setStatus(String status) {
		this.status = status;
	}
}