package com.distinguo.sfgpetclinic.services.map;

import com.distinguo.sfgpetclinic.model.Speciality;
import com.distinguo.sfgpetclinic.model.Vet;
import com.distinguo.sfgpetclinic.services.SpecialtyService;
import com.distinguo.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialitySet().size() > 0){
            object.getSpecialitySet().forEach(speciality ->
            {
            if(speciality.getId() == null)
            {
                Speciality savedSpecialty = specialtyService.save(speciality);
                speciality.setId(savedSpecialty.getId());
            }

                });

        }

        return super.save(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }
}
