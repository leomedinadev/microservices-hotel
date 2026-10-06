package ec.com.leodev.msh.hotels.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HotelConfig {

    @Bean("clientRest")
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }
}
