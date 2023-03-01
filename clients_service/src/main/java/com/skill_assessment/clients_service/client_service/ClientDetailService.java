package com.skill_assessment.clients_service.client_service;

import com.skill_assessment.clients_service.client_models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClientDetailService implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.getClient(username);
        return new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(), new ArrayList<>());
    }
}
