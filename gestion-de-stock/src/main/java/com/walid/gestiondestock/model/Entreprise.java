package com.walid.gestiondestock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
//@Builder

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Entreprise")
public class Entreprise extends AbstractEntity{


    @Column(name = "nom")
    private String nom;


    @Column(name = "description")
    private String description;


    @Column(name = "adresse")
    private Adresse adresse;

    @Column(name = "codeFiscla")
    private String codeFiscla;

    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;

    @Column(name = "numtel")
    private String numtel;

    @Column(name = "steweb")
    private String steweb;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;

}
