package com.app.api.login.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class OAuthLoginDto {

	@Getter @Setter
	public static class Request {
		private String memberType;
	}

	@Getter @Setter
	@Builder @NoArgsConstructor @AllArgsConstructor
	public static class Response {
		private String grantType;
		private String accessToken;
		@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private Date accessTokenExpireTime;
		private String refreshToken;
		@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private Date refreshTokenExpireTime;

	}
}
