package org.pfe.tn.Controllers;

import org.pfe.tn.Repositories.CaissierRepository;
import org.pfe.tn.Services.ICaissierService;
import org.pfe.tn.entities.Caissier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caissier")
@CrossOrigin("*")
public class CaissierController {

    @Autowired
    ICaissierService iCaissierService;

    @GetMapping
    public List<Caissier> getAll(){
        return iCaissierService.retrieveAllCaissier();

    }
    @GetMapping("{idCaissier}")

    public Optional<Caissier> retrieveInscription(@PathVariable Long idCaissier) {

        return  iCaissierService.retrieveCaissier(idCaissier);

    }
    @PostMapping

    public Caissier addCaissier(@RequestBody Caissier Caissier){

        return iCaissierService.addCaissier(Caissier);
    }
    @DeleteMapping("{idCaissier}")
    public void removeCaissier(@PathVariable Long idCaissier){

        iCaissierService.removeCaissier(idCaissier);
    }

    @PutMapping
    public Caissier updateCaissier(@RequestBody Caissier Caissier) {

        return  iCaissierService.updateCaissier(Caissier);

    }

}