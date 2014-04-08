package com.lishibook.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	public static String getMD5(String s) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");  
        byte[] b = md.digest(s.getBytes());  
            
        return byte2HexStr(b);
	}
	
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
	
	public static String convertURIParam(String target) {  
		String charset = "UTF-8";  
		 
        try {  
            return new String(target.trim().getBytes("iso-8859-1"), charset);  
        } catch (UnsupportedEncodingException e) {  
            return target;  
        }  
    }
	
	public static void main(String[] args) throws NoSuchAlgorithmException{
		String s = "123456";
		System.out.println(getMD5(s));
	}
	
}
