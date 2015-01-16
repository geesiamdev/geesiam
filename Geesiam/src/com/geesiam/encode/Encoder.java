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
		String urlEnc = args[2];
		Encoder enc = new Encoder();
		try {
			System.out.println(enc.encodeMessage(msg, pph, urlEnc));
		} catch (Exception e) {
			System.out.println();
		}
	}

	public String encode(String msg, String pph, String urlEnc) {
		try {
			return encodeMessage(msg, pph, urlEnc);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("static-access")
	private String encodeMessage(String msg, String pph, String urlEnc)
			throws Exception {
		byte[] key = (pph).getBytes("UTF-8");
		MessageDigest sha = MessageDigest.getInstance("MD5");
		key = sha.digest(key);
		key = Arrays.copyOf(key, 8);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "DES");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		byte[] encrypted = cipher.doFinal(msg.getBytes());
		BASE64Encoder myEncoder = new BASE64Encoder();
		if (urlEnc.equals("true")) {
			return URLEncoder.encode(myEncoder.encode(encrypted), "UTF-8");
		}
		return myEncoder.encode(encrypted);
	}
}
