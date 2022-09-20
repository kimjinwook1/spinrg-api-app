package com.app.global.error.excpetion;

import com.app.global.error.ErrorCode;

public class AuthenticationException extends BusinessException{

	public AuthenticationException(ErrorCode errorCode) {
		super(errorCode);
	}
}
