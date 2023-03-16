package com.walid.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Data
//@Builder

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mvtstk")
public class MvtStk extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name = "datemvt")
    private Instant datemvt;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "typeMvt")
    private TypeMvtStk typeMvt;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;



}
