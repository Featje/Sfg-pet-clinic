package com.distinguo.sfgpetclinic.bootstrap;

import com.distinguo.sfgpetclinic.model.Owner;
import com.distinguo.sfgpetclinic.model.PetType;
import com.distinguo.sfgpetclinic.model.Vet;
import com.distinguo.sfgpetclinic.services.OwnerService;
import com.distinguo.sfgpetclinic.services.PetTypeService;
import com.distinguo.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {
        PetType cat = new PetType();
        cat.setName("Sjaakie");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Ghost");
        PetType savedDogPetType = petTypeService.save(dog);


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
