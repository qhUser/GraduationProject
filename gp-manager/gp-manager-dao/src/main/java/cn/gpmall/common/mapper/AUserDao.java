package cn.gpmall.common.mapper;

import java.util.List;

import cn.gpmall.common.pojo.AEvaluate;
import cn.gpmall.common.pojo.AOrder;
import cn.gpmall.common.pojo.AOrderlist;
import cn.gpmall.common.pojo.AUser;
import cn.gpmall.common.pojo.PAdmin;
import cn.gpmall.common.pojo.PPrivilege;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.common.pojo.UserBalance;

public interface AUserDao {

	AUser getList1(Integer id);//用户查询信息

	void getList2(UserBalance userBalance);//用户充值

	void getList3(UserBalance userBalance);//用户修改密码

	List<AOrder> getList4(Page pa);//用户查询订单
    
	AUser loginEnter(String username); //用户登录查询账户
	PAdmin adminLoginEnter(String username); //管理员登录查询账户

	void register1(AUser user);//普通用户注册

	void register2(AUser user);//企业用户注册

	List<AUser> getUserAdd(Page pa);//获得未审核的企业用户

	Integer getUserAddSum();//获得未审核企业用户总数

	void getUserAdopt(Integer id);//审核企业用户通过

	void getUsernoPass(Integer id);//审核用户不通过

	List<AUser> getUserList(Page pa);//获得所有的用户

	Integer getUserListSum();//获得所有用户总数

	void getUserBan(Integer id);//对用户封号

	List<AUser> getUserListBan(Page pa);//获得所有的违规用户

	Integer getUserListBanSum();//获得所有的违规用户总数

	void getUserRelieve(Integer id);//对用户解封

	AOrder getByOrderListId(Integer orderid);//查询相应订单

	int checkBalance(Integer userid, Double price);//查询用户是否够付款

	Integer checkBySuppId(Integer orderid);//找到订单卖家id

	Integer checkBySuppId1(Integer suppid1);//找到商品供应商

	void addMoney(Integer suppid, Double price);//卖家加钱

	void cutBack(Integer userid, Double price);//买家减轻

	void changeOrder(Integer orderid, int i);//改变订单状态

	void InserEvaluate(AEvaluate evaluate);//插入评价

	List<Integer> getRole(Integer id);//查询用户所有角色

	List<Integer> getPrivilege(Integer i);//获得角色的全部权限id 

	PPrivilege getPrivilegeById(Integer j);//根据权限id，找到权限



	
}
