package com.app;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;

public class JasyptTest {

	@Test
	void jasyptTest() {
		//given
		//암호화 할 패스워드는 테스트 실행 시 입력
		String password = "";

		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		encryptor.setPoolSize(4);
		encryptor.setPassword(password);
		encryptor.setAlgorithm("PBEWithMD5AndTripleDES");

		//when
		String content = "and0LXRva2VuLXNlY3Jlda=="; //암호화 할 내용
		String encryptedContent = encryptor.encrypt(content);// 암호화
		String decryptedContent = encryptor.decrypt(encryptedContent);

		//then
		System.out.println("encryptedContent = " + encryptedContent);
		System.out.println("decryptedContent = " + decryptedContent);
	}
}
