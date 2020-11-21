package com.cn.util;

import java.text.*;

public class StringUtil {
	//�п�
	public static Boolean isNull(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
	
	//�ж����ڸ�ʽ
	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		// ָ�����ڸ�ʽΪ��λ��/��λ�·�/��λ����
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// ����lenientΪfalse.
			// ����SimpleDateFormat��ȽϿ��ɵ���֤���ڣ�����2007/02/29�ᱻ���ܣ���ת����2007/03/01
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// ���throw java.text.ParseException����NullPointerException����˵����ʽ����
			convertSuccess = false;
		}
		return convertSuccess;
	}

	//�ж��Ƿ�Ϊ����
	public static boolean isNumeric(String str) {
		String reg = "^[0-9]+(.[0-9]+)?$";

        return str.matches(reg);
	}

}

