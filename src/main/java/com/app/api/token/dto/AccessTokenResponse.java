package com.app.api.token.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccessTokenResponse {

	private String grantType;
	private String accessToken;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date accessTokenExpireTime;

}
