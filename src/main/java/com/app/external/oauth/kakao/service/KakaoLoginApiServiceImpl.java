package com.app.external.oauth.kakao.service;

import com.app.domain.member.constant.MemberType;
import com.app.external.oauth.kakao.client.KakaoUserInfoClient;
import com.app.external.oauth.kakao.dto.KakaoUserInfoResponse;
import com.app.external.oauth.kakao.dto.KakaoUserInfoResponse.KaKaoAccount;
import com.app.external.oauth.model.OAuthAttributes;
import com.app.external.oauth.service.SocialLoginApiService;
import com.app.global.jwt.constant.GrantType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class KakaoLoginApiServiceImpl implements SocialLoginApiService {

	private final KakaoUserInfoClient kakaoUserInfoClient;
	private final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=utf-8";

	@Override
	public OAuthAttributes getUserInfo(String accessToken) {
		KakaoUserInfoResponse kakaoUserInfoResponse =
				kakaoUserInfoClient.getKakaoUserInfo(CONTENT_TYPE, GrantType.BEARER.getType() + " " + accessToken);

		KaKaoAccount kaKaoAccount = kakaoUserInfoResponse.getKaKaoAccount();
		String email = kaKaoAccount.getEmail();

		return OAuthAttributes.builder()
				.email(!StringUtils.hasText(email) ? kakaoUserInfoResponse.getId() : email)
				.name(kaKaoAccount.getProfile().getNickname())
				.profile(kaKaoAccount.getProfile().getThumbnailImageUrl())
				.memberType(MemberType.KAKAO)
				.build();
	}

}
