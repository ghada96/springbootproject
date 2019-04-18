package com.ghada.mini_projet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("r")
public class Retrait extends Operation {
    public Retrait() {
    }

    public Retrait(Date dateOperation, double montant,Compte compte) {
        super(dateOperation, montant,compte);
    }
}
