package com.skill_assessment.clients_service.client_resources;


import com.skill_assessment.clients_service.client_models.Client;
import com.skill_assessment.clients_service.client_models.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/clients")
@CrossOrigin(maxAge = 3600)
public class ClientController {

    @Autowired
    private ClientHandler clientHandler;

    @GetMapping("/a")
    public String start() {
        log.info("Server up and running");
        return "Success";
    }

    @PostMapping("/sign-up")
    public Client registerNewClient(@RequestBody Client clientRequest) throws Exception {
        log.info("Create new client request received {}", clientRequest.toString());
        return clientHandler.registerNewClient(clientRequest);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) throws Exception {
        log.info("login request received");
        return clientHandler.login(loginRequest);
    }


    @GetMapping("/validate")
    public boolean validateClient(@RequestHeader("Authorization") String authHeader) {
        log.info("Authenticate jwt request received");
        return clientHandler.validateClient(authHeader);
    }
}
