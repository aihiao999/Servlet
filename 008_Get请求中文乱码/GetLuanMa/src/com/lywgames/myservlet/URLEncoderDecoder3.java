package com.lywgames.myservlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDecoder3 {
	public static void main(String[] args) {
		try {
			// URLEncoder.encode("的的确确", "utf-8") ==> %E7%9A%84%E7%9A%84%E7%A1%AE%E7%A1%AE
			// URLDecoder.decode("%E7%9A%84%E7%9A%84%E7%A1%AE%E7%A1%AE", "ISO-8859-1") ==> ççç¡®ç¡®
			System.out.println(URLEncoder.encode("的的确确", "utf-8"));
			System.out.println(URLDecoder.decode("%E7%9A%84%E7%9A%84%E7%A1%AE%E7%A1%AE", "ISO-8859-1"));
			// 把ççç¡®ç¡®打散到ISO-8859-1对应的字节数组 , 然后再按utf-8组拼字符串
			System.out.println(new String("ççç¡®ç¡®".getBytes("ISO-8859-1"), "utf-8"));
			
			// URLEncoder.encode("的的确确", "gbk") ==> %B5%C4%B5%C4%C8%B7%C8%B7
			// URLDecoder.decode("%B5%C4%B5%C4%C8%B7%C8%B7", "ISO-8859-1") ==> µÄµÄÈ·È·"
			System.out.println(URLEncoder.encode("的的确确", "gbk"));
			System.out.println(URLDecoder.decode("%B5%C4%B5%C4%C8%B7%C8%B7", "ISO-8859-1"));
			// 把µÄµÄÈ·È·打散到ISO-8859-1对应的字节数组 , 然后再按gbk组拼字符串
			System.out.println(new String("µÄµÄÈ·È·".getBytes("ISO-8859-1"), "gbk"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
