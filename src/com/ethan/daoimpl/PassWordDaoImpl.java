package com.ethan.daoimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ethan.enumDom.AttributeInfo;

import com.ethan.Util.BeanUtil;
import com.ethan.Util.DESEncryptUtil;
import com.ethan.Util.DateUtil;
import com.ethan.Util.FileUtil;
import com.ethan.Util.ReadPropertiseUtil;
import com.ethan.entity.PassWordInfo;

/**
 * @ClassName: PassWordDaoImpl
 * @Description: 密码实体类
 * @author: GuoqingPang
 * @date: 2017年8月6日 下午10:09:58
 * 
 * @Copyright: 2017 Ethan.Pang Inc. All rights reserved.
 * 注意：本内容仅做毕业设计用。
 */
public class PassWordDaoImpl {
	
	private static final String HOU_ZHUI = ".properties";
	
	/**
	 * @throws IOException 
	 * @Title: createPassInfo
	 * @Description: 创建密码信息
	 * @param: 
	 * @return: void
	 * @throws
	 */
	public void createPassInfo(PassWordInfo passWordInfo, String fileName){
		String id = DateUtil.dateToStamp();
		String value = BeanUtil.benaToStr(passWordInfo);
		try {
			String desId = DESEncryptUtil.encryption(id);
			ReadPropertiseUtil.WriteProperties(AttributeInfo.DATA_INFO + fileName + HOU_ZHUI, desId, value);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: delPassInfo
	 * @Description: 删除
	 * @param: @param userName
	 * @param: @param id
	 * @return: void
	 * @throws
	 */
	public void delPassInfo(String userName, String id){
		String desId;
		try {
			desId = DESEncryptUtil.encryption(id);
			FileUtil.deleFileLine(userName, desId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws IOException 
	 * @Title: selectPassInfo
	 * @Description: 根据用户名查找所有数据信息
	 * @param: @param userName
	 * @return: void
	 * @throws
	 */
	public List<PassWordInfo> selectPassInfo(String userName){
		try {
			List<Map<String, String>> dataSource = ReadPropertiseUtil.GetAllProperties(AttributeInfo.DATA_INFO + userName +HOU_ZHUI);
			return mapToPass(dataSource);
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<PassWordInfo>();
		}
	}
	
	/**
	 * 
	 * @Title: searchPassInfo
	 * @Description: 模糊匹配
	 * @param: @param userName
	 * @param: @param str
	 * @param: @return
	 * @param: @throws IOException
	 * @return: List<PassWordInfo>
	 * @throws
	 */
	public List<PassWordInfo> searchPassInfo(String userName, String str){
		try {
			List<Map<String, String>> dataSource = ReadPropertiseUtil.GetAllProperties(AttributeInfo.DATA_INFO + userName +HOU_ZHUI);
			List<PassWordInfo> data = mapToPass(dataSource);
			System.out.println(str);
			if("".equals(str)){
				return data;
			}
			List<PassWordInfo> list = new ArrayList<PassWordInfo>();
			for (int i = 0; i < data.size(); i++) {
				PassWordInfo pass = data.get(i);
				String name = pass.getLocationName();
				if(name.indexOf(str) >= 0){
					list.add(pass);
				}
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<PassWordInfo>();
		}
	}
	
	private List<PassWordInfo> mapToPass(List<Map<String, String>> dataSource){
		List<PassWordInfo> list = new ArrayList<PassWordInfo>();
		try {
			for (int i = 0; i < dataSource.size(); i++) {
				Map<String, String> map = dataSource.get(i);
				PassWordInfo passWordInfo = new PassWordInfo();
				String id = map.get(AttributeInfo.KEY);
				String value = map.get(AttributeInfo.VALUE);
				passWordInfo.setId(DESEncryptUtil.decryption(id));
				String[] arr = value.split(",");
				for (int j = 0; j < arr.length; j++) {
					String str = DESEncryptUtil.decryption(arr[j]);
					switch (j) {
					case 0:
						passWordInfo.setLocationName(str);
						break;
					case 1:
						passWordInfo.setLocationUrl(str);
						break;
					case 2:
						passWordInfo.setUserName(str);
						break;
					case 3:
						passWordInfo.setUserPass(str);
						break;
					case 4:
						passWordInfo.setBindingPhone(str);
						break;
					case 5:
						passWordInfo.setBindingEmail(str);
						break;
					case 6:
						passWordInfo.setBindingQQ(str);
						break;
					case 7:
						passWordInfo.setCreateTime(str);
						break;
					}
				}
				list.add(passWordInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
