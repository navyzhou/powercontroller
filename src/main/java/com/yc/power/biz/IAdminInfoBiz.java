package com.yc.power.biz;

import java.util.List;

import com.yc.power.bean.AdminInfo;
import com.yc.power.bean.Menu;

public interface IAdminInfoBiz {
	/**
	 * 会员登录
	 * @param account
	 * @param pwd
	 * @return
	 */
	public AdminInfo adminLogin(String aid,String pwd);
	
	public List<Menu> findMenu(int aid);
}
