package com.walid.gestion.de.stock.dto;

import com.walid.gestion.de.stock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;


@Data
@Builder
public class VentesDto {
    private Integer id;

    private String code;

    private Instant datevente;

    private String commentaire;


    public VentesDto fromEntity(Ventes ventes) {

        if (ventes == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return VentesDto.builder()
                .id(ventes.getId())
                .code(ventes.getCode())
                .datevente(ventes.getDatevente())
                .commentaire(ventes.getCommentaire())
                .build();
    }

    public Ventes toEntity(VentesDto ventesDto) {

        if (ventesDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        Ventes ventes = new Ventes();
        ventes.setId(ventesDto.getId());
        ventes.setCode(ventesDto.getCode());
        ventes.setDatevente(ventesDto.getDatevente());


        return ventes;

    }

}
