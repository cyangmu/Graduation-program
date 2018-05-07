package com.nkl.common.util;

import java.security.MessageDigest;

/**
 * MD5加密 实现32位,16位密码算法,默认字符编码为UTF-8
 * 
 * @author x
 * 
 */
public class MD5Util {

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * MD5 32位加密
	 * 
	 * @param origin
	 *            字符源
	 * @param charset
	 *            字符编码
	 * @return 32位密文
	 */
	public static String code32(String origin, String charset) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charset == null) {
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			} else {
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charset)));
			}
		} catch (Exception exception) {
		}
		return resultString;
	}

	/**
	 * MD5 16位加密
	 * 
	 * @param origin
	 *            字符源
	 * @param charset
	 *            字符编码
	 * @return 16位密文
	 */
	public static String code16(String origin, String charset) {
		String resultString = code32(origin, charset);
		return resultString.substring(8, 24);
	}

	private static String toHexStr(byte b[]) {
		StringBuffer resultSb = new StringBuffer();

		for (int i = 0; i < b.length; i++) {
			resultSb.append(byte2Hex(b[i]));
		}

		return resultSb.toString();
	}

	private static String byte2Hex(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static byte[] encode(byte[] input) {

		byte[] output = null;

		MessageDigest digester = null;

		try {

			digester = MessageDigest.getInstance("MD5");

			digester.update(input);

			output = digester.digest();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;
	}

	public static String encode(String str) {

		byte[] input = null, output = null;

		String md5 = null;

		try {

			input = str.getBytes("UTF-8");

			output = MD5Util.encode(input);

			md5 = MD5Util.toHexStr(output);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return md5;

	}


	public static void main(String[] args) {
		String str = MD5Util.code32("1234567890","utf8");

		String test = "E807F1FCF82D132F9BB018CA6738A19F";
		System.out.println(str);
		System.out.println(test.equals(str.toUpperCase()));
	}
}
