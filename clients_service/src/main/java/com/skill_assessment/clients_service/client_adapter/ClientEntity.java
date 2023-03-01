package com.skill_assessment.clients_service.client_adapter;



import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients_table")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    @NonNull
    @Setter
    @OneToOne(cascade = CascadeType.PERSIST)
    private AddressEntity addressEntity;
}
