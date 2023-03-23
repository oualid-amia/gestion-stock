package com.walid.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import com.walid.gestiondestock.model.CommandFournisseur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class CommandeFournisseurDto {


    private Integer id;

    private String code;

    private Instant dateCommande;


//    @JsonIgnore
    private FournisseurDto fournisseur;

//    @JsonIgnore
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;


    public static CommandeFournisseurDto fromEntity(CommandFournisseur commandFournisseur) {

        if (commandFournisseur == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return CommandeFournisseurDto.builder()
                .id(commandFournisseur.getId())
                .code(commandFournisseur.getCode())
                .dateCommande(commandFournisseur.getDateCommande())
                .build();
    }

    public static CommandFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {

        if (commandeFournisseurDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        CommandFournisseur commandFournisseur = new CommandFournisseur();
        commandFournisseur.setId(commandeFournisseurDto.getId());
        commandFournisseur.setCode(commandeFournisseurDto.getCode());
        commandFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());


        return commandFournisseur;

    }
}
