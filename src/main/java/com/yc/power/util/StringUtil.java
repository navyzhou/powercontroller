package com.yc.power.util;

public class StringUtil {
	/**
	 * 为空判断
	 * @param params
	 * @return
	 */
	public static boolean isNull(String ... params){
		if(params!=null && params.length>0){
			for(String param:params){
				if( param==null || "".equals(param) ){
					return true;
				}
			}
			return false;
		}else{
			return false;
		}
	}
}	
