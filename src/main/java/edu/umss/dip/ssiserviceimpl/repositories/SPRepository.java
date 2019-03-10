package edu.umss.dip.ssiserviceimpl.repositories;

import java.util.List;

public interface SPRepository<T> {
    List<T> spFindAll();
    T spSave(T model);
    void spDeleteById(Long id);
}
