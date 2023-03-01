package com.skill_assessment.clients_service.client_adapter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import org.springframework.stereotype.Component;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
@Table(name = "addresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String no;
    private String street;
    private String city;
    private String postalCode;


    @OneToOne(mappedBy = "addressEntity")
    @JsonIgnore
    private ClientEntity clientEntity;
}

