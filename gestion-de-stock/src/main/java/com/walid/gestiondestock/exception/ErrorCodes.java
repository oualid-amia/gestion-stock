package com.walid.gestiondestock.exception;

import lombok.Getter;

public enum ErrorCodes {


    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALIDE(2001),
    CLIENT_NOT_FOUND(3000),
    COMMANDE_CLIENT_NOT_FOUND(4000),
    COMMANDE_CLIENT_NOT_VALIDE(4001),

    COMMANDE_FOURNISSEUR_NOT_FOUND(5000),
    COMMANDE_FOURNISSEUR_NOT_VALIDE(5001),
    ENTREPRISE_NOT_FOUND(6000),
    FOURNISSEUR_NOT_FOUND(7000),
    LIGNE_COMMANDE_CLIENT_NOT_FOUND(8000),
    LIGNE_COMMANDE_FOURNISSEUR_NOT_FOUND(9000),
    LIGNE_VENTE_NOT_FOUND(10000),
    MVT_STK_NOT_FOUND(11000),
    UTILISATEUR_NOT_FOUND(12000),
    VENTES_NOT_FOUND(13000),
    VENTES_NOT_VALIDE(13001)
    ;




//    @Getter
    private int code;

    ErrorCodes(int code){

        this.code = code;
    }

    public int getCode(){

        return code;
    }
}
