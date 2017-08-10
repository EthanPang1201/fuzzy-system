package com.ethan.Util;

import com.ethan.entity.PassWordInfo;

public class BeanUtil {

	private static String str;

	private static final String ED = ",";

	public static String benaToStr(PassWordInfo passWordInfo) {
		if (null == passWordInfo) {
			return "";
		}
		try {
			passWordInfo.setCreateTime(DateUtil.getNowDate());
			str = DESEncryptUtil.encryption(passWordInfo.getLocationName()) + ED
					+ DESEncryptUtil.encryption(passWordInfo.getLocationUrl()) + ED
					+ DESEncryptUtil.encryption(passWordInfo.getUserName()) + ED
					+ DESEncryptUtil.encryption(passWordInfo.getUserPass()) + ED
					+ DESEncryptUtil.encryption(passWordInfo.getBindingPhone()) + ED
					+ DESEncryptUtil.encryption(passWordInfo.getBindingEmail()) + ED
					+ DESEncryptUtil.encryption(passWordInfo.getBindingQQ()) + ED
					+ DESEncryptUtil.encryption(passWordInfo.getCreateTime());
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
