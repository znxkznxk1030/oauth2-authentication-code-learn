package ys.kim.clientserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CelloController {

    Logger log = LoggerFactory.getLogger(CelloController.class);

    @Autowired
    private WebClient webClient;

    @GetMapping(value = "/cello")
    public String[] getCelloDatas(
            @RegisteredOAuth2AuthorizedClient("cello-authorization-code") OAuth2AuthorizedClient authorizedClient) {

        log.info("access scope: {}", authorizedClient.getAccessToken().getScopes());
        log.info("access value: {}", authorizedClient.getAccessToken().getTokenValue());
        return this.webClient.get()
                .uri("http://localhost:8081/cello")
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .retrieve()
                .bodyToMono(String[].class)
                .block();
    }

}
