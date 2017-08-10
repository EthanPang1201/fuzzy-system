package com.ethan.Util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.ethan.enumDom.AttributeInfo;

/**
 * 
 * @ClassName: ReadPropertiseUtil
 * @Description: 读取配置文件算法
 * @author: GuoqingPang
 * @date: 2017年8月5日 上午11:09:14
 * 
 * @Copyright: 2017 Ethan.Pang Inc. All rights reserved.
 * 注意：本内容仅做毕业设计用。
 */
public class ReadPropertiseUtil {
	/**
	 * 
	 * @Title: GetValueByKey
	 * @Description: 根据KEY读取Value
	 * @param: @param filePath
	 * @param: @param key
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public static String GetValueByKey(String filePath, String key) {
	    Properties pps = new Properties();
	    try {
	        InputStream in = new BufferedInputStream (new FileInputStream(filePath));  
	        pps.load(in);
	        return pps.getProperty(key);
	    }catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	/**
	 * 
	 * @Title: GetAllProperties
	 * @Description: 读取Properties的全部信息
	 * @param: @param filePath
	 * @param: @throws IOException
	 * @return: void
	 * @throws
	 */
	public static List<Map<String, String>> GetAllProperties(String filePath) throws IOException {
	    Properties pps = new Properties();
	    List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	    InputStream in = new BufferedInputStream(new FileInputStream(filePath));
	    pps.load(in);
	    Enumeration<?> en = pps.propertyNames(); //得到配置文件的名字
	    while(en.hasMoreElements()) {
	    	Map<String, String> map = new HashMap<String, String>();
	    	String strKey = (String) en.nextElement();
	    	String strValue = pps.getProperty(strKey);
	    	map.put(AttributeInfo.KEY, strKey);
	    	map.put(AttributeInfo.VALUE, strValue);
	    	list.add(map);
	    }
	    return list;
	}
	
	/**
	 * 
	 * @Title: WriteProperties
	 * @Description: 写入Properties信息
	 * @param: @param filePath
	 * @param: @param pKey
	 * @param: @param pValue
	 * @param: @throws IOException
	 * @return: void
	 * @throws
	 */
	public static void WriteProperties (String filePath, String pKey, String pValue) throws IOException {
	    Properties pps = new Properties();
	    InputStream in = new FileInputStream(filePath);
	    //从输入流中读取属性列表（键和元素对） 
	    pps.load(in);
	    //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。  
	    //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
	    OutputStream out = new FileOutputStream(filePath);
	    pps.setProperty(pKey, pValue);
	    //以适合使用 load 方法加载到 Properties 表中的格式，  
	    //将此 Properties 表中的属性列表（键和元素对）写入输出流  
	    pps.store(out, "last Update " + "NAME:" + pKey);
	}
	
	public static void main(String [] args) throws IOException{
//	    String value = GetValueByKey("res/userInfo/userInfo.properties", "ethan");
//	    System.out.println(value);
//	    GetAllProperties("Test.properties");
	    WriteProperties("res/userInfo/userInfo.properties","long111", "2222=1=");
	}
}
