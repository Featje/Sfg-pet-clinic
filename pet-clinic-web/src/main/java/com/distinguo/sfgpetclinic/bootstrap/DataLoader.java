package com.distinguo.sfgpetclinic.bootstrap;

import com.distinguo.sfgpetclinic.model.*;
import com.distinguo.sfgpetclinic.services.OwnerService;
import com.distinguo.sfgpetclinic.services.PetTypeService;
import com.distinguo.sfgpetclinic.services.SpecialtyService;
import com.distinguo.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtiesService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);


        Owner owner1 = new Owner();
        owner1.setFirstName("Vincent");
        owner1.setLastName("Sterrenburg");
        owner1.setAddress("Ceintuurbaan 29");
        owner1.setCity("Deventer");
        owner1.setTelephone("0624587006");

        Pet vincPet = new Pet();
        vincPet.setPetType(savedCatPetType);
        vincPet.setOwner(owner1);
        vincPet.setBirthdate(LocalDate.now());
        vincPet.setName("Sjaakie");
        owner1.getPets().add(vincPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Daphne");
        owner2.setLastName("Postma");
        owner2.setAddress("Ceintuurbaan 29");
        owner2.setCity("Deventer");
        owner2.setTelephone("0183 301253");

        Pet vincPet2 = new Pet();
        vincPet2.setPetType(savedDogPetType);
        vincPet2.setOwner(owner2);
        vincPet2.setBirthdate(LocalDate.now());
        vincPet2.setName("Sjaakie2");
        owner2.getPets().add(vincPet2);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Theo");
        vet1.setLastName("Willemsen");
        vet1.getSpecialitySet().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Riek");
        vet2.setLastName("Hebert");
        vet2.getSpecialitySet().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
