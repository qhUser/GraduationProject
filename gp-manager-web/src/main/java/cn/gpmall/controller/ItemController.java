package cn.gpmall.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gpmall.common.pojo.ACom;
import cn.gpmall.common.pojo.EasyUIData;
import cn.gpmall.service.ItemService;

/**
 * 商品管理Controller
 * <p>Title: ItemController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemservice;
	/*
	 * 查询商品
	 * */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIData getList(Integer page, Integer rows) {
		EasyUIData result=itemservice.getPage(page, rows);
		return result;				
	}
	
	/*
	 * 审查未审核商品
	 * */
	@RequestMapping("/item/add")
	@ResponseBody
	public EasyUIData getAdd(Integer page, Integer rows) {
		EasyUIData result=itemservice.getAdd(page, rows);
		return result;				
	}
	/**
	 * 审查商品通过
	 * */
	@RequestMapping("/item/adopt")
	@ResponseBody
	public String getAdopt(Integer id) {
		itemservice.getAdopt(id);
		return "success";
	}
	/*
	 * 审查商品不通过
	 * */
	@RequestMapping("/item/noPass")
	@ResponseBody
	public String getNoPass(Integer id) {
		itemservice.getNoPass(id);
		return "success";
	}
	@RequestMapping("/list")
	public String getList() {
		return "item-list";
	}
	@RequestMapping("/add")
	public String getAdd() {
		return "item-add";
	}
}
