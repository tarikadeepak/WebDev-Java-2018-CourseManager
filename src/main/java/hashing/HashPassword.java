package hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
	public String hashPassword(String password) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer();
		for(byte bytePassword : b)
			sb.append(Integer.toHexString(bytePassword & 0Xff).toString());
		return sb.toString();
	}
}
