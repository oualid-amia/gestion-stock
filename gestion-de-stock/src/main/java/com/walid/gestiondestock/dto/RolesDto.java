package com.walid.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestiondestock.model.Roles;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RolesDto {
    private Integer id;

    private String roleName;

    @JsonIgnore
    private UtilisateurDto utilisateur;



    public static RolesDto fromEntity(Roles roles) {

        if (roles == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto) {

        if (rolesDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());




        return roles;

    }

}
