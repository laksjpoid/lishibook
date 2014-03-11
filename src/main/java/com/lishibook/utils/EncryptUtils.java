package com.lishibook.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	public static String getMD5(String s) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");  
        byte[] b = md.digest(s.getBytes());  
            
        return byte2HexStr(b);
	}
	
	/**
	 * 将二进制数组转换为16进制字符串形式
	 * @param b
	 * @return
	 */
	public static String byte2HexStr(byte[] b) {  
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < b.length; i++) {  
            String s = Integer.toHexString(b[i] & 0xFF);  
            if (s.length() == 1) {  
                 sb.append("0");  
            }  
                  
            sb.append(s.toLowerCase());
         }  
              
         return sb.toString();  
    }
	
	public static void main(String[] args) throws NoSuchAlgorithmException{
		String s = "123456";
		System.out.println(getMD5(s));
	}
}
