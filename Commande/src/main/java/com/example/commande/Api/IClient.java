package com.example.commande.Api;

import com.example.commande.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="customer-service")
public interface IClient {
    @GetMapping("/customer/profiles/{idp}")
    public Client findById(@PathVariable long idp);
}
