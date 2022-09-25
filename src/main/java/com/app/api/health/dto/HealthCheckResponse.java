package com.app.api.health.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthCheckResponse {

	@Schema(description = "서버 health 상태", example = "ok", required = true)
	private String health;
	@Schema(description = "현재 실행중인 profile", example = "[dev]", required = true)
	private List<String> activeProfiles;
}
