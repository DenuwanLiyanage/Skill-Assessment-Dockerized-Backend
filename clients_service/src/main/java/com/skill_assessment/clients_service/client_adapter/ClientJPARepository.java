package com.skill_assessment.clients_service.client_adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJPARepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity getClientByUsername(String username);
}
