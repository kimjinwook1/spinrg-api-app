package com.app.api.token.controller;

import com.app.api.token.dto.AccessTokenResponse;
import com.app.api.token.service.TokenService;
import com.app.global.util.AuthorizationHeaderUtils;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TokenController {

	private final TokenService tokenService;

	@PostMapping("/access-token/issue")
	public ResponseEntity<AccessTokenResponse> createAccessToken(HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");
		AuthorizationHeaderUtils.validateAuthorization(authorizationHeader);

		String refreshToken = authorizationHeader.split(" ")[1];
		AccessTokenResponse accessTokenResponse = tokenService.createAccessTokenByRefreshToken(refreshToken);
		return ResponseEntity.ok(accessTokenResponse);
	}
}
