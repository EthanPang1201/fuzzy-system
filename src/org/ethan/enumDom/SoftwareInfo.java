package org.ethan.enumDom;

/**
 * 
 * @ClassName: SoftwareInfo
 * @Description: 软件相关枚举类
 * @author: GuoqingPang
 * @date: 2017年8月4日 下午4:47:05
 * 
 * @Copyright: 2017 Ethan.Pang Inc. All rights reserved.
 * 注意：本内容仅做毕业设计用。
 */
public enum SoftwareInfo {
	NAME("密码本"),
	AUTHOR("Ethan.pang"),
	VERSION("1.0.0.0"),
	TITLE(" 欢迎使用密码本 "),
	STATEMENT("@Copyright: 2017 Ethan.Pang Inc. All rights reserved.");
	
	private final String value;
	
	SoftwareInfo(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
