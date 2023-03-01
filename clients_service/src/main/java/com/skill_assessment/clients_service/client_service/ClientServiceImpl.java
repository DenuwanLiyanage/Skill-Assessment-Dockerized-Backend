package com.skill_assessment.clients_service.client_service;

import com.skill_assessment.clients_service.client_models.Client;
import com.skill_assessment.clients_service.client_models.LoginRequest;
import com.skill_assessment.clients_service.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientDetailService clientDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Client registerNewClient(Client clientRequest) throws Exception {
        return clientRepository.create(clientRequest);
    }

    @Override
    public String login(LoginRequest loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
            ));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception("Invalid username or password");
        }

        return jwtUtil.generateToken(loginRequest.getUsername());
    }

    @Override
    public boolean validateClient(String authHeader) {
        String token = authHeader.substring(7);

        try {
            String username = jwtUtil.extractUsername(token);
            var client = clientDetailService.loadUserByUsername(username);
            return jwtUtil.validateToken(token, client);
        } catch (Exception e) {
            return false;
        }

    }
}
