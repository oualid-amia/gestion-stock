package com.walid.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
//@Builder

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CommandFournisseur")
public class CommandFournisseur extends AbstractEntity{


    @Column(name = "code")
    private String code;

    @Column(name = "datecommande")
    private Instant dateCommande;


    @Column(name = "idEntreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idfournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandefournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
}
