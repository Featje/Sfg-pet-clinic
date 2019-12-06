package com.distinguo.sfgpetclinic.bootstrap;

import com.distinguo.sfgpetclinic.model.Owner;
import com.distinguo.sfgpetclinic.model.Vet;
import com.distinguo.sfgpetclinic.services.OwnerService;
import com.distinguo.sfgpetclinic.services.VetService;
import com.distinguo.sfgpetclinic.services.map.OwnerServiceMap;
import com.distinguo.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();

    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Vincent");
        owner1.setLastName("Sterrenburg");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Daphne");
        owner2.setLastName("Postma");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Theo");
        vet1.setLastName("Willemsen");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Riek");
        vet2.setLastName("Hebert");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
