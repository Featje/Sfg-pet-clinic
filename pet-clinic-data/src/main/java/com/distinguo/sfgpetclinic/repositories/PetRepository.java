package com.distinguo.sfgpetclinic.repositories;

import com.distinguo.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
