package com.ethan.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	private static final String BASE_PATH = "res/otherInfo/";
	
	private static final String HOU_ZHUI = ".properties";
	
	private static File file;
	
	/**
	 * @Title: createFile
	 * @Description: 创建文件
	 * @param: @param fileName
	 * @return: void
	 * @throws
	 */
	public static void createFile(String fileName){
		file = new File(BASE_PATH+fileName+HOU_ZHUI);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void updateFileName(String oldFileName, String newFileName){
		file = new File(BASE_PATH+oldFileName+HOU_ZHUI);
		file.renameTo(new File(BASE_PATH+newFileName+HOU_ZHUI));
	}
	
	public static void deleFileLine(String fileName, String id){
		List<String> list = new ArrayList<String>();
		try {
			file = new File(BASE_PATH+fileName+HOU_ZHUI);
			FileReader reader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(reader);
			String line = bReader.readLine();
			for(;line != null; line = bReader.readLine()){
				if(!line.startsWith(id)){
					list.add(line);
				}
			}
			bReader.close();
			reader.close();
			FileWriter writer = new FileWriter(file);
			BufferedWriter bWriter = new BufferedWriter(writer);
			for (String str : list) {
				bWriter.write(str);
				bWriter.newLine();
			}
			bWriter.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		deleFileLine("1234", "123");
	}
}
