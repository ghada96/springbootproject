package com.ghada.mini_projet.web;

import com.ghada.mini_projet.Compte;
import com.ghada.mini_projet.IBanqueMetier;
import com.ghada.mini_projet.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BanqueController {
    @Autowired
    private IBanqueMetier banqueMetier;

    @RequestMapping("/operations")
    public String index() {
        return "compte";
    }


    @RequestMapping("/consultercompte")
    public String consultercompte(Model model, String codecompte) {
        model.addAttribute("codecompte",codecompte);

        Compte cp=banqueMetier.consulter(codecompte);
        //Page<Operation>listoperation=banqueMetier.listOperation(codecompte,0,4);
       // model.addAttribute("listoperation",listoperation.getContent());
        model.addAttribute("compte",cp);
        return "compte";
    }

    @RequestMapping(value="/saveOperation",method= RequestMethod.POST)
    public String saveOperation(Model model,String typeOperation, String codecompte,double montant, String codecompte2) {

        try {
            if(typeOperation.equals("vers")) {

               banqueMetier.verser(codecompte,montant);
            } else if(typeOperation.equals("retrait")) {

               banqueMetier.retirer(codecompte,montant);
            } else  {

                banqueMetier.virement(codecompte,codecompte2,montant);
            }
        }catch (Exception e) {
            model.addAttribute("error",e);
            return "redirect:/consultercompte?codecompte="+codecompte+"&error="+e.getMessage();
        }


        return "redirect:/consultercompte?codecompte="+codecompte;
    }
}
