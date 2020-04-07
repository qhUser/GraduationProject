package cn.gpmall.search.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SmartDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.Page;
import cn.gpmall.common.pojo.UserComment;
import cn.gpmall.search.service.ItemListService;
import cn.gpmall.search.service.SearchService;

@Controller
public class ItemListController {
     @Autowired
    private ItemListService itemListService;
    @Autowired
    private SearchService searchService;
     

	@RequestMapping("/list")	  //获得solr索引库商品
	public String getItemList(@RequestParam(defaultValue="")String keyword, @RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="8")Integer rows,Model model) throws Exception{	
		
		keyword = new String(keyword.getBytes("iso-8859-1"), "utf-8");	
	    Page pa=new Page();
	    pa=searchService.search(keyword, page, rows);	
		model.addAttribute("itemList", pa);
		return "item-list";
	}
	
	@RequestMapping("/details")   //获得商品详情
	public  String getDetails(Integer id,Model model) {
		ACom ac=new ACom();
		ac=itemListService.getDetails(id);
		model.addAttribute("item",ac);
		Date date=new Date();
		long time1 = date.getTime();
		long time2 =ac.getEnddate().getTime();
		long time=time2-time1;
//		System.out.println("剩余时间:"+time);
//		SimpleDateFormat sdf=new SimpleDateFormat("dd.HH.mm.ss");
//		String format = sdf.format(time);
//		System.out.println(format);
		model.addAttribute("date",time);
		return "details";
	}
	
	@RequestMapping("/addprice")
	@ResponseBody              //加价
	public String addPrice(Integer itemid,Integer userid,Double nowprice) {
		itemListService.addPrice(itemid,userid,nowprice);
		return "ok";
	}
	@RequestMapping("/bail")
	@ResponseBody              //缴纳保证金
	public String checkBail(Integer id) {
		String bail=itemListService.checkBail(id);
		return bail;
	}
	@RequestMapping("/usercomment")
	@ResponseBody              //获得商品供应商信誉
	public UserComment userComment(Integer itemid) {
		UserComment bail=itemListService.userComment(itemid);//根据商品id查找到商品供应商
		return bail;
	}
}
