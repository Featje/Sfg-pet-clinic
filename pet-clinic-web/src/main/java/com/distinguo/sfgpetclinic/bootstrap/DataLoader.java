package com.distinguo.sfgpetclinic.bootstrap;

import com.distinguo.sfgpetclinic.model.Owner;
import com.distinguo.sfgpetclinic.model.Vet;
import com.distinguo.sfgpetclinic.services.OwnerService;
import com.distinguo.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Vincent");
        owner1.setLastName("Sterrenburg");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daphne");
        owner2.setLastName("Postma");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Theo");
        vet1.setLastName("Willemsen");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Riek");
        vet2.setLastName("Hebert");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
