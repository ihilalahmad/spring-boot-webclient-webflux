package com.codingzest.first_spring_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.codingzest.first_spring_app.request_models.MyRequestModel;

import reactor.core.publisher.Mono;

@Service
public class MyService {

    @Autowired
    private WebClient webClient;
    
    public void sendPostRequest(){
        MyRequestModel myRequestModel = new MyRequestModel("Hilal Ahmad", "hilal@gmail.com");

        webClient.post()
                 .uri("/api/postData")
                 .body(Mono.just(myRequestModel), MyRequestModel.class)
                 .retrieve()
                 .bodyToMono(String.class)
                 .subscribe(response -> {
                     // Handle the response
                     System.out.println("Response: " + response);
                 });
    }

    public String getCatBreeds(){
       String catBreeds =  webClient.get()
                  .uri("breeds")
                  .retrieve()
                  .bodyToMono(String.class)
                  .block();

                  System.out.println("----------------");
                  System.out.println(catBreeds);

                  return catBreeds;
    }
}
