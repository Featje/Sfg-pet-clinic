package com.distinguo.sfgpetclinic.services.map;

import com.distinguo.sfgpetclinic.model.PetType;
import com.distinguo.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);

    }

    @Override
    public void deleteByID(Long id) {
    super.deleteById(id);
    }
}
