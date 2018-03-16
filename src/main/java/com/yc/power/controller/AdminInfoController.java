package com.yc.power.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.google.gson.Gson;
import com.yc.power.bean.AdminInfo;
import com.yc.power.bean.Menu;
import com.yc.power.biz.IAdminInfoBiz;

@Controller
public class AdminInfoController {
	@Autowired
	private IAdminInfoBiz adminInfoBiz;
	
	@RequestMapping("/adminLogin")
	@ResponseBody
	public String adminLogin(HttpSession session,String aid,String pwd){
		AdminInfo adminInfo=this.adminInfoBiz.adminLogin(aid, pwd);
		Gson gson=new Gson();
		if(adminInfo==null){
			return gson.toJson(null);
		}else{
			session.setAttribute("currentLoginAdmin", adminInfo);
			return gson.toJson(adminInfo);
		}
	}
	
	@RequestMapping("/back/loginOk")
	public String loginOk(){
		return "WEB-INF/back/index";
	}
	
	@RequestMapping("/back/menuInfo")
	@ResponseBody
	public String menuInfo(HttpSession session){
		Object obj=session.getAttribute("currentLoginAdmin");
		if(obj!=null){
			List<Menu> list=this.adminInfoBiz.findMenu(((AdminInfo)obj).getAid() );
			System.out.println( list );
			Gson gson=new Gson();
			return gson.toJson(list);
		}else{
			return "";
		}
	}
	
	@RequestMapping("/back/**")
	public String backInfo(HttpServletRequest request ){
		String path=request.getRequestURI().replace(request.getContextPath(),"");
		return "WEB-INF/"+path;
	}
}
