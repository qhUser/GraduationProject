package cn.gpmall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gpmall.common.pojo.ACom;
import cn.gpmall.service.ItemService;

@Controller
public class Show {
  @Autowired
  private ItemService itemService;
  
  @RequestMapping("/list/new")
  @ResponseBody
  public List<ACom> newList() {
	 	List<ACom> list = itemService.getNew();
	 	return list;
  }
  @RequestMapping("/list/onSale")
  public List<ACom> onSale(){
	  List<ACom> list=itemService.getonSale();
	  return list;
  }
  
  @RequestMapping("/")
  public String show(){
	  return "index";
  }
}
