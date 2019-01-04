package util;

import org.apache.commons.lang.RandomStringUtils;

import javax.xml.bind.SchemaOutputResolver;

public class RandomCode {
	public static int genCode(){
		int code = (int)((Math.random()*9+1)*100000);
		return code;
	}
	
	public static void main(String[] args) {
		System.out.println(RandomCode.genCode());
		String code = RandomStringUtils.randomNumeric(6);
		System.out.println(code);
	}
}
