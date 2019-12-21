package guru.springframework.msscbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BroweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer";

    private String apihost;

    private final RestTemplate restTemplate;

    public BroweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
