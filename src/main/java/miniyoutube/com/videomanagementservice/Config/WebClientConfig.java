package miniyoutube.com.videomanagementservice.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
