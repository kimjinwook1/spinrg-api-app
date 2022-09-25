package com.app.global.error.excpetion;

import com.app.global.error.ErrorCode;

public class EntityNotFoundException extends BusinessException{

	public EntityNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}
}
