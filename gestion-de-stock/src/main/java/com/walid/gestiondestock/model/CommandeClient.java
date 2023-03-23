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
@Table(name = "CommandeClient")
public class CommandeClient extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "datecommande")
    private Instant dateCommande;

    @Column(name = "etatCommande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;

    @OneToMany(mappedBy = "commandeclient" )
    private List<LigneCommandeClient> lingeCommadeclients;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;


}
