package com.demo.spring.util;

import com.demo.spring.dto.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "account-producer", url = "${app.inventory.account-base-url}" )
public interface  AccountClient {

    @RequestMapping(method = RequestMethod.GET, value = "/account")
    ResponseEntity<Account> getAccount();
}
