package com.anabatic.sandbox.helper;

import java.math.BigInteger;
import java.security.MessageDigest;

import sun.security.util.BigInt;

public class EncryptHelper {
	public static synchronized String md5(String text){
		String enc="";
		try{
			MessageDigest digest=MessageDigest.getInstance("MD5");
			digest.update(text.getBytes(),0,text.length());
			enc=new BigInteger(1,digest.digest()).toString(16);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return enc;
	}
}
