package shop.uflu.platform.core.merchantapi.service.impl;

import javax.enterprise.context.ApplicationScoped;

import shop.uflu.platform.core.merchantapi.service.api.HealthCheckService;

@ApplicationScoped
public class HealthCheckServiceBean implements HealthCheckService {

	@Override
	public String check() {
		return "OK";
	}

}
