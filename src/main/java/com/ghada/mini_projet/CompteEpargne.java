package com.ghada.mini_projet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("ce")
public class CompteEpargne extends Compte {
    private double taux;

    public CompteEpargne(String code, Date dateCreation, Double solde, double taux) {
        super(code, dateCreation, solde);
        this.taux = taux;
    }
    public  CompteEpargne(){

    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
