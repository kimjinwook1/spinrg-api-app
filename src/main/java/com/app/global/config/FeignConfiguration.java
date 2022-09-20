package com.app.global.config;

import com.app.global.error.FeignClientExceptionErrorDecoder;
import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableFeignClients(basePackages = "com.app") //todo 패키지명 수정
@Import(FeignClientConfiguration.class)
public class FeignConfiguration {

	@Bean
	Logger.Level feignLoggerLevel() {
		//로그정보가 많이 남는 것 -> FULL
		return Logger.Level.FULL;
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new FeignClientExceptionErrorDecoder();
	}

	@Bean
	public Retryer retryer() {
		//period : 실행 주기
		//maxAttempts : 최대 몇 번의 재시도를 할 지
		return new Retryer.Default(1000, 2000, 3);
	}
}
