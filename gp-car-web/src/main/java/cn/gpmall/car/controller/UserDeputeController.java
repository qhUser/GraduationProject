package cn.gpmall.car.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.gpmall.car.service.UserDeputeService;
import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.Camouflage;
import cn.gpmall.common.pojo.ComTypeAll;
import cn.gpmall.common.pojo.OrderAll;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.common.utils.FastDFSClient;
import cn.gpmall.common.utils.JsonUtils;

@Controller
public class UserDeputeController {
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Autowired
	UserDeputeService userDepute;
    @RequestMapping("/deupte")/*进入发布拍卖页,1是普通用户只能发布委托,2,3是企业机构,能接受拍卖委托*/
    public String getIndex(Integer id,@RequestParam(defaultValue="1")Integer page,Model model){
    	if(id==1) {
    		return "deupte";
    	}
    	else {
    		//返回委托分页数
    		Page pa=new Page(page,10);
    		Integer sum=userDepute.getSum();
        	pa.setSum(sum);
        	model.addAttribute("itemList", pa);
        	model.addAttribute("level",3);
    		return "deupte";
    	}
    }
    @RequestMapping("/switchitem")
    @ResponseBody/*获得商品的所有类型，返回给用户选择*/
    public ComTypeAll getSwitchItem() {    	
    	ComTypeAll comType=new ComTypeAll();
    	comType=userDepute.getSwitchItem();       
    	return comType;
    }
    @RequestMapping("/picture")/*发布委托商品，提交图片,添加商品等操作*/
    public String addItem(MultipartFile pictureFile,Integer swit,String comName,String startDate,String endDate,Double lastprice,
    		Integer count,String descript,Integer id,Integer level,Model model) throws Exception{
    	//swit = new String(swit.getBytes("iso-8859-1"), "utf-8");	
    	String originalFilename = pictureFile.getOriginalFilename();
		String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
		//2、创建一个FastDFS的客户端
		FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
		//3、执行上传处理
		String path = fastDFSClient.uploadFile(pictureFile.getBytes(), extName);
		//4、拼接返回的url和ip地址，拼装成完整的url
		String url = IMAGE_SERVER_URL + path;
		//System.out.println(swit+url+comName+startDate+endDate+lastprice+count+descript+id);
		userDepute.addItem(url,swit,comName,startDate,endDate,lastprice,count,descript,id,level);
		model.addAttribute("key", "ok");
		if(level==1) {
    		return "deupte";
    	}
    	else {
    		//返回委托分页数
    		Page pa=new Page(1,10);
    		Integer sum=userDepute.getSum();
        	pa.setSum(sum);
        	model.addAttribute("itemList", pa);
        	model.addAttribute("level",3);
    		return "deupte";
    	}
    }
    @RequestMapping("/accept")
    @ResponseBody/*查询所有委托商品,返回委托商品列表*/
    public String getAccept(@RequestParam(defaultValue="1") Integer page,Model model) {
    	Map map=new HashMap<>();
    	Page pa=new Page(page,10);
    	OrderAll order =new OrderAll();
    	order=userDepute.getAccept(pa);   	
    	Integer sum=userDepute.getSum();
    	pa.setSum(sum);
    	map.put("page", pa);
    	map.put("comlist",order);
    	return JsonUtils.objectToJson(map);
    
    }
    @RequestMapping("/check")
    @ResponseBody/*查询指定委托商品*/
    public ACom getCheck(Integer id) {
    	ACom ac=new ACom();
    	ac=userDepute.getCheck(id);
    	return ac;
    }
    @RequestMapping("/acceptCom")
    @ResponseBody/*接受委托商品操作，找到商品id,修改供应商id,*/
    public String getAcceptCom(Integer comid,Integer suppid) {
    	System.out.println("供应商id为:"+suppid);
    	userDepute.getAcceptCom(comid,suppid);
    	return "ok";
    }
    
}
