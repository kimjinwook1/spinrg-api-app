package com.app.external.oauth.service;

import com.app.domain.member.constant.MemberType;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class SocialLoginApiServiceFactory {

	private static Map<String, SocialLoginApiService> socialLoginApiServices;

	public SocialLoginApiServiceFactory(Map<String, SocialLoginApiService> socialLoginApiServices) {
		//Map 의 key값으로 bean의 이름, value에는 소셜로그인 api서비스의 구현체가 들어간다.
		//SocialLoginApiService의 구현체들이 먼저 빈으로 등록되고
		//그 다음에 SocialLoginApiServiceFactory에 해당 빈들을 주입해서 SocialLoginApiServiceFactory도 빈으로 등록을 해준다.
		//스프링이 빈 등록 및 다른 빈 주입해주는것도 자동으로 해주는것이죠
		//@Service 어노테이션이 붙었기 떄문에 빈 등록, 빈 주입을 자동으로 해줌
		this.socialLoginApiServices = socialLoginApiServices;
	}

	public static SocialLoginApiService getSocialLoginApiService(MemberType memberType) {
		String socialLoginApiServiceBeanName = "";

		if (MemberType.KAKAO.equals(memberType)) {
			socialLoginApiServiceBeanName = "kakaoLoginApiServiceImpl";
		}
		return socialLoginApiServices.get(socialLoginApiServiceBeanName);
	}

}
