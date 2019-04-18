package com.ghada.mini_projet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("cc")//type_compte =cc , variable declaré en DiscriminatorColumn
public class CompteCourant extends Compte {
    private double decouvert;

    public CompteCourant() {

    }

    public CompteCourant(String code ,Date dateCreation, Double solde, double decouvert) {
        super(code,dateCreation, solde);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
