package cn.gpmall.common.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户信息表
 * */
public class AUser implements Serializable {
    private Integer id;  //用户id

    private String loginname; //登录名

    private String nickname; //昵称

    private String password; //密码

    private String email;    //邮箱

    private String phonenumber; //

    private Boolean gender;   //性别  0女  1男

    private Double balance;   //账户余额

    private Integer honesty;  //信誉值  100分值  初始60分 ，毁拍一次扣50分，被投诉一次扣10分，卖假货扣50分，0分以下不允许进行买卖

    private String organization; //机构名称 针对公司注册

    private Date createdate;    //创建日期

    private Boolean visable;    //是否可见

    private String address;     //送货地址
    private Double bail;           //用户是否缴纳保证金

    private String img;    //图片

    private Integer level;      /*
    客户级别 1普通用户，只能竞拍  2高级用户，能竞拍和拍卖，3.公司账户，能竞拍和拍卖
    */
    private String Type;  //用户类型显示
    private AUsertype userType;//外键表，与level关联
    
    
    
    public Double getBail() {
		return bail;
	}

	public void setBail(Double bail) {
		this.bail = bail;
	}

	public AUsertype getUserType() {
		return userType;
	}

	public void setUserType(AUsertype userType) {
		this.userType = userType;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getHonesty() {
        return honesty;
    }

    public void setHonesty(Integer honesty) {
        this.honesty = honesty;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Boolean getVisable() {
        return visable;
    }

    public void setVisable(Boolean visable) {
        this.visable = visable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    
	public String getType() {
		if(this.level!=null&&this.level==1)
		return "普通用户";
		else {
			return "企业用户";
		}
	}

	public void setType(String type) {
		
	}

	@Override
	public String toString() {
		return "AUser [id=" + id + ", loginname=" + loginname + ", nickname=" + nickname + ", password=" + password
				+ ", email=" + email + ", phonenumber=" + phonenumber + ", gender=" + gender + ", balance=" + balance
				+ ", honesty=" + honesty + ", organization=" + organization + ", createdate=" + createdate
				+ ", visable=" + visable + ", address=" + address + ", bail=" + bail + ", img=" + img + ", level="
				+ level + ", Type=" + Type + ", userType=" + userType + "]";
	}

  

	
    
}