package com.ghada.mini_projet;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.nio.MappedByteBuffer;
import java.util.Collection;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeClient;
    private String nomClient;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)//liste de compte de client n'est pas chargé automatiquement
    //liste des comptes vont etre chargé que au cas de besoin (si j'appelle la methode getComptes
    private Collection<Compte>comptes;

    public Client() {
    }
    public Client(String nomClient) {
        this.nomClient = nomClient;

    }

    public Long getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(Long codeClient) {
        this.codeClient = codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    @JsonIgnore
    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
