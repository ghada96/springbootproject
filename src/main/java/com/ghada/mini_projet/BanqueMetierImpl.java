package com.ghada.mini_projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Compte consulter(String code) {
        Compte cp = compteRepository.findById(code).get();
        return cp;

    }


    @Override
    public void verser(String code, double montant) {
        Compte cp =consulter(code);
        Versement v=new Versement(new Date(),montant,cp);
        operationRepository.save(v);
        cp.setSolde(cp.getSolde()+montant);
        compteRepository.save(cp);



    }

    @Override
    public void retirer(String code, double montant) {
        Compte cp =consulter(code);
        double decouvert=0;
        if(cp instanceof CompteCourant){
            decouvert=((CompteCourant) cp).getDecouvert();
        }
        if(cp.getSolde()+decouvert<montant)throw new RuntimeException("solde insuffisant");
        Retrait r =new Retrait(new Date(),montant,cp);
        operationRepository.save(r);
        cp.setSolde(cp.getSolde()-montant);
        compteRepository.save(cp);

    }

    @Override
    public void virement(String code1, String code2, double montant) {
        if(code1.equals(code2))throw new RuntimeException("choisir un compte valide");
        retirer(code1,montant);
        verser(code2,montant);

    }

    @Override
    public Page<Operation> listOperation(String code, int page, int size) {
        return operationRepository.listOperation(code, PageRequest.of(page,size));
    }
}
