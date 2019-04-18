package com.ghada.mini_projet;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface IBanqueMetier {
    public Compte consulter(String code);
    public void verser(String code, double montant);
    public void retirer(String code, double montant);
    public void virement(String code1, String code2, double montant);
    public Page<Operation> listOperation(String code, int page, int size);
}
