package com.walid.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
//@Builder

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Fournisseur")
public class Fournisseur extends AbstractEntity{

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Embedded
    private Adresse adresse;

    @Column(name = "photo")
    private String photo;

    @Column(name = "mail")
    private String mail;

    @Column(name = "numtel")
    private String numtel;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandFournisseur> commandFournisseurs;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;
}
