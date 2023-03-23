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
@Table(name = "LigneVente")
public class LigneVente extends AbstractEntity{


    @ManyToOne
    @JoinColumn(name = "idventes")
    private Ventes ventes;


    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name = "quantite")
    private BigDecimal quantite;


    @Column(name = "prixunitaire")
    private BigDecimal prixunitaire;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;
}
