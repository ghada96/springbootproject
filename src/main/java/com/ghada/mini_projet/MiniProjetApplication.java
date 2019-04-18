package com.ghada.mini_projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@ComponentScan(value = "com.ghada")
public class MiniProjetApplication implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired

    private IBanqueMetier banqueMetier;


    public static void main(String[] args) {
        SpringApplication.run(MiniProjetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Client cl1=new Client("ghada");
        Client cl2=new Client("aziz");
        List<Client> clients=new ArrayList<>();
        clients.add(cl1);
        clients.add(cl2);
        this.clientRepository.saveAll(clients);
       Compte c1= compteRepository.save(new CompteCourant("c1",new Date(),1236.3,126.5));
        Compte c2=compteRepository.save(new CompteEpargne("c2",new Date(),123.5,55.6));

        operationRepository.save(new Versement(new Date(),450,c1));
        operationRepository.save(new Retrait(new Date(),699,c2));
        banqueMetier.verser("c1",50);

    }
}
