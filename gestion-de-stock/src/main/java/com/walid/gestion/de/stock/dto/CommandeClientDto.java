package com.walid.gestion.de.stock.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestion.de.stock.model.CommandClient;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class CommandeClientDto {
    private Integer id;

    private String code;

    private Instant dateCommande;


    @JsonIgnore
    private ClientDto client;
    @JsonIgnore
    private List<LigneCommandeClientDto> lingeCommadeclients;



    public CommandeClientDto fromEntity(CommandClient commandClient) {

        if (commandClient == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return CommandeClientDto.builder()
                .id(commandClient.getId())
                .code(commandClient.getCode())
                .dateCommande(commandClient.getDateCommande())
                .build();
    }

    public CommandClient toEntity(CommandeClientDto commandeClientDto) {

        if (commandeClientDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        CommandClient commandClient = new CommandClient();
        commandClient.setId(commandeClientDto.getId());
        commandClient.setCode(commandeClientDto.getCode());
        commandClient.setDateCommande(commandeClientDto.getDateCommande());


        return commandClient;

    }
}
