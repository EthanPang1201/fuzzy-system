package com.ethan.daoimpl;

import java.io.IOException;

import org.ethan.enumDom.AttributeInfo;

import com.ethan.Util.DESEncryptUtil;
import com.ethan.Util.FileUtil;
import com.ethan.Util.ReadPropertiseUtil;
import com.ethan.Util.StringUtil;
import com.ethan.entity.UserInfo;

/**
 * 
 * @ClassName: UserDaoImpl
 * @Description: 用户信息实体类
 * @author: GuoqingPang
 * @date: 2017年8月5日 上午10:57:16
 * 
 * @Copyright: 2017 Ethan.Pang Inc. All rights reserved.
 * 注意：本内容仅做毕业设计用。
 */
public class UserDaoImpl {
	UserInfo userInfo;
	
	/**
	 * 
	 * @Title: getUserInfo
	 * @Description: 根据用户名查找用户
	 * @param: @param userName
	 * @param: @return
	 * @return: UserInfo
	 * @throws
	 */
	public UserInfo getUserInfo(String userName){
		try {
			String desName = DESEncryptUtil.encryption(userName);
			String pass = ReadPropertiseUtil.GetValueByKey(AttributeInfo.USER_INFO, desName);
			if(StringUtil.isEntrty(pass)){
				return null;
			}else{
				userInfo = new UserInfo();
				userInfo.setUserName(userName);
				userInfo.setUserPass(DESEncryptUtil.decryption(pass));
				return userInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new UserInfo();
	}
	
	/**
	 * @throws IOException 
	 * 
	 * @Title: createUser
	 * @Description: 创建用户
	 * @param: @param name
	 * @param: @param pass
	 * @return: void
	 * @throws
	 */
	public void createUser(String name, String pass) {
		try {
			ReadPropertiseUtil.WriteProperties(AttributeInfo.USER_INFO, DESEncryptUtil.encryption(name), DESEncryptUtil.encryption(pass));
			FileUtil.createFile(name);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: updateUser
	 * @Description: 更新密码
	 * @param: @param user
	 * @param: @return
	 * @return: boolean
	 * @throws
	 */
	public boolean updateUser(UserInfo user){
		try {
			ReadPropertiseUtil.WriteProperties(AttributeInfo.USER_INFO, DESEncryptUtil.encryption(user.getUserName()), DESEncryptUtil.encryption(user.getUserPass()));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
