package ys.kim.clientserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@RestController
public class CelloController {

  @Autowired
  private WebClient webClient;

  @GetMapping(value = "/cello")
  public String[] getCelloDatas(
      @RegisteredOAuth2AuthorizedClient("cello-authorization-code") OAuth2AuthorizedClient authorizedClient) {
    return this.webClient.get()
        .uri("http://localhost:8081/cello")
        .attributes(oauth2AuthorizedClient(authorizedClient))
        .retrieve()
        .bodyToMono(String[].class)
        .block();
  }

}
