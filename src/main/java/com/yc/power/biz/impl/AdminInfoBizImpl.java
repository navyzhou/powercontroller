package com.yc.power.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.power.bean.AdminInfo;
import com.yc.power.bean.Menu;
import com.yc.power.biz.IAdminInfoBiz;
import com.yc.power.dao.IBaseDao;
import com.yc.power.util.StringUtil;

@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class AdminInfoBizImpl implements IAdminInfoBiz{
	@Autowired
	private IBaseDao baseDao;

	@Override
	public AdminInfo adminLogin(String aid, String pwd) {
		if(StringUtil.isNull(aid,pwd)){
			return null;
		}else{
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("aid",aid);
			map.put("pwd",pwd);
			return (AdminInfo) this.baseDao.find(AdminInfo.class,map,"adminInfoLogin");
		}
	}

	@Override
	public List<Menu> findMenu(int aid) {
		return this.baseDao.findAll(AdminInfo.class,aid,"menuInfo");
	}
}
