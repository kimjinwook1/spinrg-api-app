package com.app.api.login.dto;

import com.app.global.jwt.dto.JwtTokenDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import io.swagger.v3.oas.annotations.media.Schema;
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
		@Schema(description = "소셜 로그인 회원 타입", example = "KAKAO", required = true)
		private String memberType;
	}

	@Getter @Setter
	@Builder @NoArgsConstructor @AllArgsConstructor
	public static class Response {

		@Schema(description = "grantType", example = "Bearer", required = true)
		private String grantType;

		@Schema(description = "accessToken", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQ0NFU1MiLCJpYXQiOjE2NjQxMDcwOTMsImV4cCI6MTY2NDEwNzk5MywibWVtYmVySWQiOjEsInJvbGUiOiJBRE1JTiJ9.gXNh_CE6h8QIpdbU3c-DGNTvDMrO1g4AHRblXIdphyBwPXaUYlIW7u5HKpqQAFaCC255YZKK6BB5MUlHU81QoA", required = true)
		private String accessToken;

		@Schema(description = "access token 만료시간", example = "2022-09-25 21:13:13", required = true)
		@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private Date accessTokenExpireTime;

		@Schema(description = "refreshToken", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSRUZSRVNIIiwiaWF0IjoxNjY0MTA3MDkzLCJleHAiOjE2NjUzMTY2OTMsIm1lbWJlcklkIjoxLCJyb2xlIjoiQURNSU4ifQ.c7Gx2Q4bsYMDGtPaNHRkeXWSb9M9PcsK2BS90w0O59azTnNOYximpo1soIRpOEw8_asdfasdf0LCg4CdKAY1b8w", required = true)
		private String refreshToken;

		@Schema(description = "refresh token 만료시간", example = "2022-10-09 20:58:13", required = true)
		@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private Date refreshTokenExpireTime;

		public static Response of(JwtTokenDto jwtTokenDto) {
			return Response.builder()
					.grantType(jwtTokenDto.getGrantType())
					.accessToken(jwtTokenDto.getAccessToken())
					.accessTokenExpireTime(jwtTokenDto.getAccessTokenExpireTime())
					.refreshToken(jwtTokenDto.getRefreshToken())
					.refreshTokenExpireTime(jwtTokenDto.getRefreshTokenExpireTime())
					.build();
		}
	}
}
