package com.ghada.mini_projet;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity

@XmlRootElement
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "type_compte",discriminatorType =DiscriminatorType.STRING,length = 2)
//specification de la colonne qui fait la difference entre les differents types de compte
public class Compte implements Serializable {
   @Id

    private String code;
    private Date dateCreation;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "code_emp")
    private Employe employe;
    @ManyToOne
    @JoinColumn(name = "code_client")
    private Client client;
    @OneToMany(mappedBy = "compte",fetch = FetchType.LAZY)
    private Collection<Operation>operations;



    public Compte(){

    }

    public Compte(String code, Date dateCreation, Double solde) {
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }
}
