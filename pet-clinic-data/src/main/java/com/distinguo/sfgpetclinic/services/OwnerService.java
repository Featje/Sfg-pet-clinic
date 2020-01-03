package com.distinguo.sfgpetclinic.services;

import com.distinguo.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName (String lastName);
}
