package com.app.api.login.controller;

import com.app.api.login.dto.OAuthLoginDto;
import com.app.api.login.service.OAuthLoginService;
import com.app.api.login.validator.OAuthValidator;
import com.app.domain.member.constant.MemberType;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/oauth")
public class OAuthLoginController {

	private final OAuthValidator oAuthValidator;
	private final OAuthLoginService oAuthLoginService;

	@PostMapping("/login")
	public ResponseEntity<OAuthLoginDto.Response> oauthLogin(
			@RequestBody OAuthLoginDto.Request oauthLoginRequestDto,
			HttpServletRequest request) {

		String authorizationHeader = request.getHeader("Authorization");
		oAuthValidator.validateAuthorization(authorizationHeader);
		oAuthValidator.validateMemberType(oauthLoginRequestDto.getMemberType());

		String accessToken = authorizationHeader.split(" ")[1];
		oAuthLoginService.oauthLogin(accessToken, MemberType.from(oauthLoginRequestDto.getMemberType()));

		return ResponseEntity.ok(OAuthLoginDto.Response.builder().build());
	}
}
