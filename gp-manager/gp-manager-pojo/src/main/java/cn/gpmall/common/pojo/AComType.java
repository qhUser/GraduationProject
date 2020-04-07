package cn.gpmall.common.pojo;

import java.io.Serializable;
/**
 * 商品类型表
 * */
public class AComType implements Serializable{
    private Integer id;  //商品类型id

    private Integer parentId; //商品类型父id

    private String typename;  //商品类型名称

    private Byte isParent;    //是否为父节点   0父节点 1 不是父节点

    private Byte visable;     //是否删除 0删除 1未删除

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Byte getIsParent() {
        return isParent;
    }

    public void setIsParent(Byte isParent) {
        this.isParent = isParent;
    }

    public Byte getVisable() {
        return visable;
    }

    public void setVisable(Byte visable) {
        this.visable = visable;
    }
}