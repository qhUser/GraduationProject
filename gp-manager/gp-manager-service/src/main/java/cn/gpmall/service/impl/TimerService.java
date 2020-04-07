package cn.gpmall.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.gpmall.common.mapper.AComDao;
import cn.gpmall.common.mapper.OrderDao;
import cn.gpmall.common.pojo.ACom;
import cn.gpmall.service.ItemService;

/**
 * 定时器，后台自动运行，用于判定商品拍卖是否到期
 * */

public class TimerService implements ServletContextListener{ 
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}
	//tomcat启动后会执行该方法
	public void contextInitialized(ServletContextEvent sce) {
		//获得Spring容器
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
      //从Spring容器中获得SelectDataServlet的实例
        AComDao aCom = ctx.getBean(AComDao.class);
        OrderDao orderDao=ctx.getBean(OrderDao.class);
		Timer time=new Timer();
		TimerTaskService timerTask=new TimerTaskService(aCom,orderDao);//TimerTask抽象类的实现
		time.schedule(timerTask,1000,5000);//每秒判定一次，查询一次数据库		
	}	
}
