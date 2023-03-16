package com.walid.gestion.de.stock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestion.de.stock.model.Roles;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RolesDto {
    private Integer id;

    private String roleName;

    @JsonIgnore
    private UtilisateurDto utilisateur;



    public RolesDto fromEntity(Roles roles) {

        if (roles == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public Roles toEntity(RolesDto rolesDto) {

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
