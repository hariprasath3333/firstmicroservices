package com.trial.microservices.apigateway.configuration;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p-> p.path("/get")
						.filters(f-> f
								.addRequestHeader("MyHeader", "MyUri")
								.addRequestParameter("Param", "MyValue"))
						.uri("http://httpbin.org:80"))
				.route(p->p.path("/currency-exchange/**")// any request of this type
						.uri("lb://currency-exchange")) // redirect using load balancing through Eureka service named currency-exchange appending the remaining url
				.route(p->p.path("/currency-conversion/**")
						.uri("lb://currency-conversion"))
				.route(p->p.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion"))
				.route(p->p.path("/currency-conversion-new/**")
						.filters(f-> f.rewritePath("/currency-conversion-new(?<segment>.*)",
								"/currency-conversion-feign/${segment}"))
						.uri("lb://currency-conversion"))
				.build();
	}
}
