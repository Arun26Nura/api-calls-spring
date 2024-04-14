package com.demo.spring.util;

import com.demo.spring.dto.Account;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AccountClient {

    private final RestClient accountRestClient;

    public AccountClient(RestClient accountRestClient) {
        this.accountRestClient = accountRestClient;
    }

    public Account getAccount() {

        Account account= accountRestClient.get()
                .uri("/account")
                .retrieve()
                .body(Account.class);
        return account;
    }
}
