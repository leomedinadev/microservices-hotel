package ec.com.leodev.msh.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/msh-gateway-dev/apiHotel/**")
						.filters(f -> f.rewritePath("/msh-gateway-dev/apiHotel/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time",new Date().toString()))
						.uri("lb://HOTELS")).
				route(p -> p
						.path("/msh-gateway-dev/apiRooms/**")
						.filters(f -> f.rewritePath("/msh-gateway-dev/apiRooms/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time",new Date().toString()))
						.uri("lb://ROOMS")).
				route(p -> p
						.path("/msh-gateway-dev/apiReservations/**")
						.filters(f -> f.rewritePath("/msh-gateway-dev/apiReservations/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time",new Date().toString()))
						.uri("lb://RESERVATIONS")).build();
	}

}
