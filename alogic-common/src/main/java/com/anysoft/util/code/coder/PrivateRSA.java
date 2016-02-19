package com.anysoft.util.code.coder;

import com.anysoft.util.KeyGen;
import com.anysoft.util.code.Coder;
import com.anysoft.util.code.util.RSAUtil;

/**
 * 基于RSA采用私钥加密/解密
 * 
 * @author duanyy
 *
 */
public class PrivateRSA implements Coder {	
	public String encode(String data,String key) {
		return RSAUtil.encryptWithPrivateKey(data, key);
	}
	
	public String decode(String data,String key) {
		return RSAUtil.decryptWithPrivateKey(data, key);
	}
	
	public String sign(String data,String key){
		return RSAUtil.sign(data, key);
	}
	
	public String createKey(){
		return KeyGen.getKey(8);
	}
}