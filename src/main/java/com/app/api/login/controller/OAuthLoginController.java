package com.app.api.login.controller;

import com.app.api.login.dto.OAuthLoginDto;
import com.app.api.login.dto.OAuthLoginDto.Response;
import com.app.api.login.service.OAuthLoginService;
import com.app.api.login.validator.OAuthValidator;
import com.app.domain.member.constant.MemberType;
import com.app.global.util.AuthorizationHeaderUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "authentication", description = "로그인/로그아웃/토큰재발급 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/oauth")
public class OAuthLoginController {

	private final OAuthValidator oAuthValidator;
	private final OAuthLoginService oAuthLoginService;

	@Tag(name = "authentication")
	@Operation(summary = "소셜 로그인 API", description = "소셜 로그인 API")
	@PostMapping("/login")
	public ResponseEntity<OAuthLoginDto.Response> oauthLogin(
			@RequestBody OAuthLoginDto.Request oauthLoginRequestDto,
			HttpServletRequest request) {

		String authorizationHeader = request.getHeader("Authorization");
		AuthorizationHeaderUtils.validateAuthorization(authorizationHeader);
		oAuthValidator.validateMemberType(oauthLoginRequestDto.getMemberType());

		String accessToken = authorizationHeader.split(" ")[1];
		Response jwtTokenResponseDto =
				oAuthLoginService.oauthLogin(accessToken, MemberType.from(oauthLoginRequestDto.getMemberType()));

		return ResponseEntity.ok(jwtTokenResponseDto);
	}
}
