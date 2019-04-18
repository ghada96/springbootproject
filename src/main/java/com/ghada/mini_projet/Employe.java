package com.ghada.mini_projet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeemp;
    private String nomemp;
    @ManyToOne
    @JoinColumn(name="code_empsup")
    private Employe employesup;
    @ManyToMany

    @JoinTable(name = "emp_gr")
    private Collection<Groupe> groupes;

    public Long getCodeemp() {
        return codeemp;
    }

    public void setCodeemp(Long codeemp) {
        this.codeemp = codeemp;
    }

    public String getNomemp() {
        return nomemp;
    }

    public void setNomemp(String nomemp) {
        this.nomemp = nomemp;
    }

    public Employe getEmployesup() {
        return employesup;
    }

    public void setEmployesup(Employe employesup) {
        this.employesup = employesup;
    }

    public Collection<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Collection<Groupe> groupes) {
        this.groupes = groupes;
    }
}
