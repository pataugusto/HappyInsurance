package com.patrickhestad.project.insurancecompany.config;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.base.JsonMappingExceptionMapper;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.base.JsonParseExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		final ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
		scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class));

		final Set<Class<?>> beans = scanner.findCandidateComponents("com.patrickhestad.project.insurancecompany").stream()
				.map(beanDefinition -> ClassUtils.resolveClassName(
						Objects.requireNonNull(beanDefinition.getBeanClassName()), getClassLoader())
				).collect(Collectors.toSet());
		registerClasses(beans);

		register(JsonMappingExceptionMapper.class);
		register(JsonParseExceptionMapper.class);
	}

}

