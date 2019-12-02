package com.distinguo.sfgpetclinic.services;

import com.distinguo.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findall();

}
