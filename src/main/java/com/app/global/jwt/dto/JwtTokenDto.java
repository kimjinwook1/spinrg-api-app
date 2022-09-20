package com.app.global.jwt.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtTokenDto {

	private String grantType;
	private String accessToken;
	private Date accessTokenExpireTime;
	private String refreshToken;
	private Date refreshTokenExpireTime;

}
