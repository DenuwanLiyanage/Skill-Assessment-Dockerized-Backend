package com.skill_assessment.order_service.order_service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticatorWebClient {

    public boolean isAuthenticated(String authHeader) {
        String authUrl = "http://client-service:8086/clients/validate";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", authHeader);
        headers.add("Content-Type", "application/json");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                authUrl, HttpMethod.GET, requestEntity, String.class);

        return Boolean.parseBoolean(response.getBody());

    }
}
