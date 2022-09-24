package com.app.api.token.service;

import com.app.api.token.dto.AccessTokenResponse;
import com.app.domain.member.entity.Member;
import com.app.domain.member.service.MemberService;
import com.app.global.jwt.constant.GrantType;
import com.app.global.jwt.service.TokenManager;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TokenService {

	private final MemberService memberService;
	private final TokenManager tokenManager;

	public AccessTokenResponse createAccessTokenByRefreshToken(String refreshToken) {

		Member member = memberService.findMemberByRefreshToken(refreshToken);

		Date accessTokenExpireTime = tokenManager.createAccessTokenExpireTime();
		String accessToken
				= tokenManager.createAccessToken(member.getMemberId(), member.getRole(), accessTokenExpireTime);

		return AccessTokenResponse.builder()
				.grantType(GrantType.BEARER.getType())
				.accessToken(accessToken)
				.accessTokenExpireTime(accessTokenExpireTime)
				.build();

	}
}
