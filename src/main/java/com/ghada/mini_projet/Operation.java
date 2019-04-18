package com.ghada.mini_projet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 2)
public class Operation implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numoperation;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name="code_compte")
    private Compte compte;
    @ManyToOne
    @JoinColumn(name="code_emp")
    private Employe employe;

    public Operation(){

    }

    public Operation(Date dateOperation, double montant,Compte compte) {

        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte=compte;
    }

    public Long getNumoperation() {
        return numoperation;
    }

    public void setNumoperation(Long numoperation) {
        this.numoperation = numoperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
