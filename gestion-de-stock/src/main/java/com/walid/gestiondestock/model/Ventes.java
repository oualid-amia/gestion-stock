package com.walid.gestiondestock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
//@Builder

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Ventes")
public class Ventes extends AbstractEntity {


    @Column(name = "code")
    private String code;

    @Column(name = "datevente")
    private Instant datevente;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "ventes")
    private List<LigneVente> ligneVentes;

}
