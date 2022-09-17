package com.app.api.health.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HealthCheckResponse {

	private String health;
	private List<String> activeProfiles;
}
