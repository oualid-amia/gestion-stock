package com.walid.gestion.de.stock.model;


import jakarta.persistence.*;
import lombok.*;

@Data
//@Builder

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity{


    @Column(name = "rolename")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    private Utilisateur utilisateur;


    @Column(name = "idEntreprise")
    private Integer idEntreprise;



}
