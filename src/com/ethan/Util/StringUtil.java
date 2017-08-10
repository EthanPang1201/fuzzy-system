package com.ethan.Util;

/**
 * 
 * @ClassName: StringUtil
 * @Description: 字符串工具类
 * @author: GuoqingPang
 * @date: 2017年8月5日 下午2:44:10
 * 
 * @Copyright: 2017 Ethan.Pang Inc. All rights reserved.
 * 注意：本内容仅做毕业设计用。
 */
public class StringUtil {
	
	/**
	 * 
	 * @Title: isEntrty
	 * @Description: null is true,
	 *               "" is true,
	 *               length = 0 is true,
	 *               other is false
	 * @param: @param str
	 * @param: @return
	 * @return: boolean
	 * @throws
	 */
	public static boolean isEntrty(String str){
		boolean flag = true;
		if(null != str && str != "" && str.length() !=0){
			flag = false;
		}
		return flag;
	}
}
