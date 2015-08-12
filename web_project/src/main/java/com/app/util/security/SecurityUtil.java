package com.app.util.security;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by rajdeep siddhapura.
 */
public class SecurityUtil
{
	public static String hashCal(String type, String str)
	{
		byte[] hashseq=str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try
		{
			MessageDigest algorithm = MessageDigest.getInstance(type);
			algorithm.reset();
			algorithm.update(hashseq);
			byte messageDigest[] = algorithm.digest();



			for (int i=0;i<messageDigest.length;i++)
			{
				String hex=Integer.toHexString(0xFF & messageDigest[i]);
				if(hex.length()==1) hexString.append("0");
				hexString.append(hex);
			}

		}
		catch(NoSuchAlgorithmException nsae)
		{
		}

		return hexString.toString();
	}

	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

	public static String calculateRFC2104HMAC(String data, String key) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
	{
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
		Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		mac.init(signingKey);
		return toHexString(mac.doFinal(data.getBytes()));
	}

	private static String toHexString(byte[] bytes)
	{
		Formatter formatter = new Formatter();

		for (byte b : bytes) {
			formatter.format("%02x", b);
		}

		return formatter.toString();
	}

	public static void main(String[] args) throws Exception
	{
		String hmac = calculateRFC2104HMAC("adjadbkajwdqjekq23uh", "<SALT>");

		System.out.println(hmac);
	}
}
