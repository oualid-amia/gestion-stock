package com.walid.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestiondestock.model.MvtStk;


import com.walid.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;


@Data
@Builder
public class MvtStkDto {
    private Integer id;


    @JsonIgnore
    private ArticleDto article;

    private Instant datemvt;

    private BigDecimal quantite;

   private TypeMvtStk typeMvt;


    public static MvtStkDto fromEntity(MvtStk mvtStk) {

        if (mvtStk == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .datemvt(mvtStk.getDatemvt())
                .quantite(mvtStk.getQuantite())


                .build();
    }

    public static MvtStk toEntity(MvtStkDto mvtStkDto) {

        if (mvtStkDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setDatemvt(mvtStkDto.getDatemvt());
        mvtStk.setQuantite(mvtStkDto.getQuantite());




        return mvtStk;

    }

}
