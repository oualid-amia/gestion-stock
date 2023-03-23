package com.walid.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
//@Builder

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "LigneCommandeClient")
public class LigneCommandeClient extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;


    @ManyToOne
    @JoinColumn(name = "idcommendeclient")
    private CommandeClient commandeclient;

    @Column(name = "quantite")
    private BigDecimal quantite;


    @Column(name = "prixunitaire")
    private BigDecimal prixunitaire;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;
}
