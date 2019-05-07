package com.patrickhestad.project.insurancecompany.config;

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

