package edu.umss.dip.ssiserviceimpl.repositories;

import edu.umss.dip.ssiserviceimpl.model.Rol;
import org.springframework.stereotype.Repository;

import javax.persistence.StoredProcedureQuery;

@Repository
public class RolSPRepositoryImpl extends GenericSPRepositoryImpl<Rol> implements RolSPRepository {

    @Override
    protected void setParameters(StoredProcedureQuery storedProcedureQuery, Rol model) {
        storedProcedureQuery.setParameter("name", model.getName());
    }
}
