package edu.umss.dip.ssiserviceimpl.repositories;

import edu.umss.dip.ssiserviceimpl.model.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class  SPRepositoryImpl implements SPRepository<Project> {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Project> spFindAll() {
        StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("readProject");
        return storedProcedureQuery.getResultList();
    }

    @Override
    public Project spSave(Project model) {
        StoredProcedureQuery storedProcedureQuery;

        if (model.getId() == null) {
            storedProcedureQuery = em.createNamedStoredProcedureQuery("createProject");
        } else {
            storedProcedureQuery = em.createNamedStoredProcedureQuery("updateProject");
            storedProcedureQuery.setParameter("id", model.getId());
        }

        storedProcedureQuery.setParameter("name", model.getName());
        storedProcedureQuery.setParameter("description", model.getDescription());

        return (Project) storedProcedureQuery.getSingleResult();
    }

    @Override
    public void spDeleteById(Long id) {
        StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("deleteProject");
        storedProcedureQuery.setParameter("id", id);
        storedProcedureQuery.execute();
    }
/*
    public void setIdParameter(StoredProcedureQuery storedProcedureQuery) {
        storedProcedureQuery.setParameter("id", id);
    }

    public void setParameters(StoredProcedureQuery storedProcedureQuery) {
        storedProcedureQuery.setParameter("name", model.getName());
        storedProcedureQuery.setParameter("description", model.getDescription());
    }*/
}
