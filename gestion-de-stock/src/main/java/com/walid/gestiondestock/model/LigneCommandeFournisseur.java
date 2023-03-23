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
@Table(name = "LigneCommandeFourniseur")
public class LigneCommandeFournisseur extends AbstractEntity{


    @ManyToOne
    @JoinColumn(name = "idcommandefournisseur")
    private CommandFournisseur commandefournisseur;



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
