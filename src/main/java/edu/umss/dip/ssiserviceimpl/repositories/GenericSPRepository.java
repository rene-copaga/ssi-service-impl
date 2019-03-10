package edu.umss.dip.ssiserviceimpl.repositories;

import edu.umss.dip.ssiserviceimpl.model.ModelBase;

import java.util.List;

public interface GenericSPRepository<T extends ModelBase> {
    List<T> spFindAll();
    T spSave(T model);
    void spDeleteById(Long id);
}
