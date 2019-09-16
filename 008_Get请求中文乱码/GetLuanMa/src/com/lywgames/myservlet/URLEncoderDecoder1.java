package com.lywgames.myservlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDecoder1 {
	public static void main(String[] args) {
		try {
			// URLEncoder.encode("的的确确", "utf-8") ==> %E7%9A%84%E7%9A%84%E7%A1%AE%E7%A1%AE 
			System.out.println(URLEncoder.encode("的的确确", "utf-8"));
			System.out.println(URLDecoder.decode("%E7%9A%84%E7%9A%84%E7%A1%AE%E7%A1%AE", "utf-8"));
			
			// URLEncoder.encode("的的确确", "gbk") ==> %B5%C4%B5%C4%C8%B7%C8%B7
			System.out.println(URLEncoder.encode("的的确确", "gbk"));
			System.out.println(URLDecoder.decode("%B5%C4%B5%C4%C8%B7%C8%B7", "gbk"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
