package com.distinguo.sfgpetclinic.services;

import com.distinguo.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findall();

}
