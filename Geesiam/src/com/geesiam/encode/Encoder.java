package com.geesiam.encode;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.geesiam.encode.BASE64Encoder;
import com.geesiam.encode.Encoder;

public class Encoder {
	public static void main(String[] args) {
		String msg = args[0];
		String pph = args[1];
		Encoder enc = new Encoder();
		try {
			System.out.println(enc.encodeMessage(msg, pph));
		} catch (Exception e) {
			System.out.println();
		}
	}

	public String encode(String msg, String pph) {
		try {
			return encodeMessage(msg, pph);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("static-access")
	private String encodeMessage(String msg, String pph) throws Exception {
		byte[] key = (pph).getBytes("UTF-8");
		MessageDigest sha = MessageDigest.getInstance("MD5");
		key = sha.digest(key);
		key = Arrays.copyOf(key, 16);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		byte[] encrypted = cipher.doFinal(msg.getBytes());
		BASE64Encoder myEncoder = new BASE64Encoder();
		return URLEncoder.encode(myEncoder.encode(encrypted), "UTF-8");
	}
}
