package com.app.external.oauth.kakao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoUserInfoResponse {

	private String id;

	@JsonProperty("kakao_account")
	private KaKaoAccount kaKaoAccount;


	@Getter
	@Setter
	public static class KaKaoAccount {

		private String email;
		private Profile profile;

		@Getter
		@Setter
		public class Profile {

			private String nickname;
			@JsonProperty("thumbnail_image_url")
			private String thumbnailImageUrl;
		}

	}
}
