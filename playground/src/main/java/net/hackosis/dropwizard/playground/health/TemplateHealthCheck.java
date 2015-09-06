package net.hackosis.dropwizard.playground.health;

import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheck.Result;

public class TemplateHealthCheck extends HealthCheck {

	private final String template;
	
	public TemplateHealthCheck(String template){
		this.template = template;
	}
	
	@Override
	protected Result check() throws Exception {
		final String saying = String.format(template, "TEST");
		if (!saying.contains("TEST")){
			return Result.unhealthy("Template doesn't include a name");
		}
		return Result.healthy();
	}
}
