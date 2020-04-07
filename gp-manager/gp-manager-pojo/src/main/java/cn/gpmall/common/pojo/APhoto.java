package cn.gpmall.common.pojo;

import java.io.Serializable;

/**
 * 图片路径表
 * */
public class APhoto implements Serializable{
    private Integer id;  //图片id

    private String url;  //图片存放路径
    
    private Integer objId;//商品对象id
    
    private Byte visable;  //图片是否可见

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Byte getVisable() {
        return visable;
    }

    public void setVisable(Byte visable) {
        this.visable = visable;
    }

	public Integer getObjId() {
		return objId;
	}

	public void setObjId(Integer objId) {
		this.objId = objId;
	}
    
}