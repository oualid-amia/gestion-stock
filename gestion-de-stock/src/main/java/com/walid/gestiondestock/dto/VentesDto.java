package com.walid.gestiondestock.dto;

import com.walid.gestiondestock.model.LigneVente;
import com.walid.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class VentesDto {
    private Integer id;

    private String code;

    private Instant datevente;

    private String commentaire;

    private Integer idEntreprise;

    private List<LigneVenteDto> ligneVentes;



    public static VentesDto fromEntity(Ventes ventes) {

        if (ventes == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return VentesDto.builder()
                .id(ventes.getId())
                .code(ventes.getCode())
                .datevente(ventes.getDatevente())
                .commentaire(ventes.getCommentaire())
                .idEntreprise(ventes.getIdEntreprise())
                .build();
    }

    public static Ventes toEntity(VentesDto ventesDto) {

        if (ventesDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        Ventes ventes = new Ventes();
        ventes.setId(ventesDto.getId());
        ventes.setCode(ventesDto.getCode());
        ventes.setDatevente(ventesDto.getDatevente());
        ventes.setCommentaire(ventesDto.getCommentaire());
        ventes.setIdEntreprise(ventesDto.getIdEntreprise());


        return ventes;

    }

}
