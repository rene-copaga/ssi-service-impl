package edu.umss.dip.ssiserviceimpl.repositories;

import edu.umss.dip.ssiserviceimpl.model.ModelBase;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class GenericSPRepositoryImpl<T extends ModelBase> implements GenericSPRepository<T> {
    @PersistenceContext
    private EntityManager em;

    private Class<T> getDomainClass() {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) superClass.getActualTypeArguments()[0];
    }

    @Override
    public List<T> spFindAll() {
        StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("read" + getDomainClass().getSimpleName());
        return storedProcedureQuery.getResultList();
    }

    @Override
    public T spSave(T model) {
        StoredProcedureQuery storedProcedureQuery;

        if (model.getId() == null) {
            storedProcedureQuery = em.createNamedStoredProcedureQuery("create" + getDomainClass().getSimpleName());
        } else {
            storedProcedureQuery = em.createNamedStoredProcedureQuery("update" + getDomainClass().getSimpleName());
            storedProcedureQuery.setParameter("id", model.getId());
        }

        setParameters(storedProcedureQuery, model);

        return (T) storedProcedureQuery.getSingleResult();
    }

    @Override
    public void spDeleteById(Long id) {
        StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("delete" + getDomainClass().getSimpleName());
        storedProcedureQuery.setParameter("id", id);
        storedProcedureQuery.execute();
    }

    protected abstract void setParameters(StoredProcedureQuery storedProcedureQuery, T model);

}
