package com.demo.spring.util;

import com.demo.spring.dto.Account;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AccountClient {

    private final WebClient accountWebClient;

    public AccountClient(WebClient accountWebClient) {
        this.accountWebClient = accountWebClient;
    }

    public Account getAccount() {

        return accountWebClient.get()
                .uri("/account")
                .retrieve()
                .bodyToMono(Account.class)
                .block();

    }
}
