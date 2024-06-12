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
        MyRequestModel myRequestModel = new MyRequestModel("This is my first post api from SpringBoot", 12);

        webClient.post()
                 .uri("add")
                 .body(Mono.just(myRequestModel), MyRequestModel.class)
                 .retrieve()
                 .bodyToMono(String.class)
                 .subscribe(response -> {
                     // Handle the response
                     System.out.println("Response: " + response);
                 });
    }

    public String getSinglePost(){
       String singlePost =  webClient.get()
                  .uri("1")
                  .retrieve()
                  .bodyToMono(String.class)
                  .block();

                  System.out.println("----------------");
                  System.out.println(singlePost);

                  return singlePost;
    }
}
