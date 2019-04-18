package com.ghada.mini_projet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Optional;

@Entity
@DiscriminatorValue("v")
public class Versement extends Operation {
    public Versement(Date dateOperation, int montant, Optional<Compte> cp) {
    }

    public Versement(Date dateOperation, double montant,Compte compte) {
        super(dateOperation, montant,compte);
    }
}
