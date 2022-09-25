package com.app.api.member.dto;

import com.app.domain.member.constant.Role;
import com.app.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberInfoResponse {

	private Long memberId;
	private String email;
	private String memberName;
	private String profile;
	private Role role;

	public static MemberInfoResponse of(Member member) {
		return MemberInfoResponse
				.builder()
				.memberId(member.getMemberId())
				.memberName(member.getMemberName())
				.email(member.getMemberName())
				.profile(member.getProfile())
				.role(member.getRole())
				.build();
	}
}
