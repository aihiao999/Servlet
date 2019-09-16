package com.lywgames.myservlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDecoder2 {
	public static void main(String[] args) {
		try {
			// URLEncoder.encode("的的确确", "utf-8") ==> %E7%9A%84%E7%9A%84%E7%A1%AE%E7%A1%AE
			// URLDecoder.decode("%E7%9A%84%E7%9A%84%E7%A1%AE%E7%A1%AE", "ISO-8859-1") ==> ççç¡®ç¡®
			System.out.println(URLEncoder.encode("的的确确", "utf-8"));
			System.out.println(URLDecoder.decode("%E7%9A%84%E7%9A%84%E7%A1%AE%E7%A1%AE", "ISO-8859-1"));
			
			// URLEncoder.encode("的的确确", "gbk") ==> %B5%C4%B5%C4%C8%B7%C8%B7
			// URLDecoder.decode("%B5%C4%B5%C4%C8%B7%C8%B7", "ISO-8859-1") ==> µÄµÄÈ·È·"
			System.out.println(URLEncoder.encode("的的确确", "gbk"));
			System.out.println(URLDecoder.decode("%B5%C4%B5%C4%C8%B7%C8%B7", "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
