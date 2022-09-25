package com.app.api.member.controller;

import com.app.api.member.dto.MemberInfoResponse;
import com.app.api.member.service.MemberInfoService;
import com.app.global.jwt.service.TokenManager;
import com.app.global.resolver.memberinfo.MemberInfo;
import com.app.global.resolver.memberinfo.MemberInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberInfoController {

	private final MemberInfoService memberInfoService;
	private final TokenManager tokenManager;

	@GetMapping("/info")
	public ResponseEntity<MemberInfoResponse> getMemberInfo(@MemberInfo MemberInfoDto memberInfoDto) {

		Long memberId = memberInfoDto.getMemberId();
		MemberInfoResponse memberInfoResponse = memberInfoService.getMemberInfo(memberId);

		return ResponseEntity.ok(memberInfoResponse);
	}
}
