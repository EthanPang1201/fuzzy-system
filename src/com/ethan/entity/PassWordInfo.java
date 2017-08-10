package com.ethan.entity;

/**
 * 
 * @ClassName: PassWordInfo
 * @Description:密码实体类
 * @author: GuoqingPang
 * @date: 2017年8月4日 下午4:10:18
 * 
 * @Copyright: 2017 Ethan.Pang Inc. All rights reserved.
 * 注意：本内容仅做毕业设计用。
 */
public class PassWordInfo {
	/**
	 * 标识
	 */
	private String id;
	/**
	 * 归宿地名称
	 */
	private String locationName;
	/**
	 * 归宿地URL
	 */
	private String locationUrl;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String userPass;
	/**
	 * 绑定手机
	 */
	private String bindingPhone;
	/**
	 * 绑定邮箱
	 */
	private String bindingEmail;
	/**
	 * 绑定QQ
	 */
	private String bindingQQ;
	/**
	 * 创建时间
	 */
	private String createTime;
	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationUrl() {
		return locationUrl;
	}
	public void setLocationUrl(String locationUrl) {
		this.locationUrl = locationUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getBindingPhone() {
		return bindingPhone;
	}
	public void setBindingPhone(String bindingPhone) {
		this.bindingPhone = bindingPhone;
	}
	public String getBindingEmail() {
		return bindingEmail;
	}
	public void setBindingEmail(String bindingEmail) {
		this.bindingEmail = bindingEmail;
	}
	public String getBindingQQ() {
		return bindingQQ;
	}
	public void setBindingQQ(String bindingQQ) {
		this.bindingQQ = bindingQQ;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
