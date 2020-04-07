package cn.gpmall.common.pojo;

import java.io.Serializable;

/**
 * 商品订单表
 * */
public class AOrder implements Serializable{
    private Integer id;   //订单编号

    private Integer commodityid;  //商品id

    private Integer orderlistid;  //订单详情id
    private Double price;         //生成价格
   
    private Integer count;        //购买数量
    
    private AUser aUser1;      //卖方
    private ACom aCom;          //商品
    private AOrderlist aOrderlist;//订单详情
    private AUser aUser2;      //买方
    
    
    
    public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public AUser getaUser1() {
		return aUser1;
	}

	public void setaUser1(AUser aUser1) {
		this.aUser1 = aUser1;
	}

	public ACom getaCom() {
		return aCom;
	}

	public void setaCom(ACom aCom) {
		this.aCom = aCom;
	}

	public AOrderlist getaOrderlist() {
		return aOrderlist;
	}

	public void setaOrderlist(AOrderlist aOrderlist) {
		this.aOrderlist = aOrderlist;
	}

	public AUser getaUser2() {
		return aUser2;
	}

	public void setaUser2(AUser aUser2) {
		this.aUser2 = aUser2;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public Integer getOrderlistid() {
        return orderlistid;
    }

    public void setOrderlistid(Integer orderlistid) {
        this.orderlistid = orderlistid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    
}