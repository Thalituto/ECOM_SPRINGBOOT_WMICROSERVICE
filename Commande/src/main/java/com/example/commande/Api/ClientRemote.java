package com.example.commande.Api;

import com.example.commande.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClientRemote {
    @Autowired
    WebClient webclient;

    public Mono<Client>getClient(long id){
       Mono<Client> c=webclient.get()
               .uri("/customer/profiles/{idp}",id)
               .retrieve()
               .bodyToMono(Client.class);
               return c;
    }
}
