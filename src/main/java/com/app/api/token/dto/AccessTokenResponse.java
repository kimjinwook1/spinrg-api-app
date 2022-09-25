package com.app.api.token.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccessTokenResponse {

	@Schema(description = "grantType", example = "Bearer", required = true)
	private String grantType;

	@Schema(description = "accessToken", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQ0NFU1MiLCJpYXQiOjE2NjQxMDcwOTMsImV4cCI6MTY2NDEwNzk5MywibWVtYmVySWQiOjEsInJvbGUiOiJBRE1JTiJ9.gXNh_CE6h8QIpdbU3c-DGNTvDMrO1g4AHRblXIdphyBwPXaUYlIW7u5HKpqQAFaCC255YZKK6BB5MUlHU81QoA", required = true)
	private String accessToken;

	@Schema(description = "access token 만료시간", example = "2022-09-25 21:13:13", required = true)
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date accessTokenExpireTime;

}
