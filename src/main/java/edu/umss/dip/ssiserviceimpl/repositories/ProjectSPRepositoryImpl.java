package edu.umss.dip.ssiserviceimpl.repositories;

import edu.umss.dip.ssiserviceimpl.model.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.StoredProcedureQuery;

@Repository
public class ProjectSPRepositoryImpl extends GenericSPRepositoryImpl<Project> implements ProjectSPRepository {

    @Override
    protected void setParameters(StoredProcedureQuery storedProcedureQuery, Project model) {
        storedProcedureQuery.setParameter("name", model.getName());
        storedProcedureQuery.setParameter("description", model.getDescription());
    }
}
