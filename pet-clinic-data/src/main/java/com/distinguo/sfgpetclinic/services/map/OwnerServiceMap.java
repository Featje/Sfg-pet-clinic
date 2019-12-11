package com.distinguo.sfgpetclinic.services.map;

import com.distinguo.sfgpetclinic.model.Owner;
import com.distinguo.sfgpetclinic.model.Pet;
import com.distinguo.sfgpetclinic.services.OwnerService;
import com.distinguo.sfgpetclinic.services.PetService;
import com.distinguo.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    final private PetTypeService petTypeService;
    final private PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public void delete(Owner object) {
    super.delete(object);
    }

    @Override
    public Owner findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object!=null){
            if(object.getPets() != null){
                object.getPets().forEach(pet-> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet type is requierd");
                    }
                    if(pet.getId()==null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
            }
        else{
            return null;
        }
    }

    @Override
    public void deleteByID(Long id) {
    super.deleteById(id);
    }
}
