package com.distinguo.sfgpetclinic.services.springdatajpa;

import com.distinguo.sfgpetclinic.model.Speciality;
import com.distinguo.sfgpetclinic.repositories.SpecialtyRepository;
import com.distinguo.sfgpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

public class SpecialtySDJpaService implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialtyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findByID(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
    specialtyRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
    specialtyRepository.deleteById(aLong);
    }
}
