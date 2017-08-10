package org.ethan.enumDom;

/**
 * 
 * @ClassName: LabelInfos
 * @Description: 标签枚举
 * @author: GuoqingPang
 * @date: 2017年8月4日 下午5:48:49
 * 
 * @Copyright: 2017 Ethan.Pang Inc. All rights reserved.
 * 注意：本内容仅做毕业设计用。
 */
public enum LabelInfos {
	LOGIN_NAME("用户名："),
	LOGIN_PASS("密码："),
	REMEMBER_PASS("记住密码 "),
	LOGIN("登录 "),
	SEARCH("搜索"),
	FIRST_PAGE("【首页】"),
	PREVIOUS_PAGE("【上一页】"),
	NEXT_PAGE("【下一页】"),
	LAST_PAGE("【尾页】");
	
	private final String value;
	
	LabelInfos(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
