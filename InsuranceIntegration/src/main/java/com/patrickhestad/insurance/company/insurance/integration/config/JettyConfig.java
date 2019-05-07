package com.patrickhestad.insurance.company.insurance.integration.config;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JettyConfig {

	@Bean
	public JettyServletWebServerFactory jettyEmbeddedServletContainerFactory() {
		final JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
		return factory;
	}
}
