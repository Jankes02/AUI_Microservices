package aui.lab5.gatewayapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${knight.url}") String knightUrl,
			@Value("${order.url}") String orderUrl
	) {
		return builder
				.routes()
				.route("orders", route -> route
						.path(
								"/api/orders/{uuid}",
								"/api/orders"
						)
						.uri(orderUrl)
				)
				.route("knights", route -> route
						.path(
								"/api/knights",
								"/api/knights/**",
								"/api/orders/{uuid}/knights",
								"/api/orders/{uuid}/knights/**"
						)
						.uri(knightUrl)
				)
				.build();
	}
}