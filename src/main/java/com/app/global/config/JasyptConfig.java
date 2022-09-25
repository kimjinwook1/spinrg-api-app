package com.app.global.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
public class JasyptConfig {

	// Edit configuration에 VM options에 -Djasypt.password="임의의 패스워드 값"을 지정하면 된다/
	@Value("${jasypt.password}")
	private String password;

	@Bean
	public PooledPBEStringEncryptor jasyptStringEncryptor() {
		// 멀티코어 시스템에서 해독을 병렬 처리하는 encryptor
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		encryptor.setPoolSize(4);
		encryptor.setPassword(password);
		encryptor.setAlgorithm("PBEWithMD5AndTripleDES");

		return encryptor;
	}
}
