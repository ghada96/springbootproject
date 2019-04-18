package com.ghada.mini_projet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Groupe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codegroup;
    private String nomgroup;
    @ManyToMany

    @JoinTable(name = "groupemp")
    private Collection<Employe>employes;

    public Groupe(String nomgroup) {
        this.nomgroup = nomgroup;
    }
    public  Groupe(){

    }

    public Long getCodegroup() {
        return codegroup;
    }

    public void setCodegroup(Long codegroup) {
        this.codegroup = codegroup;
    }

    public String getNomgroup() {
        return nomgroup;
    }

    public void setNomgroup(String nomgroup) {
        this.nomgroup = nomgroup;
    }

    public Collection<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(Collection<Employe> employes) {
        this.employes = employes;
    }
}
