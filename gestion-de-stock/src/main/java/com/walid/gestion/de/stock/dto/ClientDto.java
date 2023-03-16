package com.walid.gestion.de.stock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestion.de.stock.model.Client;
import jakarta.persistence.Embedded;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {
    private Integer id;

    private String nom;

    private String prenom;

    @Embedded
    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numtel;


    @JsonIgnore
    private List<CommandeClientDto> commandClients;


    public ClientDto fromEntity(Client client) {

        if (client == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numtel(client.getNumtel())
                .build();
    }

    public Client toEntity(ClientDto clientDto) {

        if (clientDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setNumtel(clientDto.getNumtel());

        return client;

    }



}
