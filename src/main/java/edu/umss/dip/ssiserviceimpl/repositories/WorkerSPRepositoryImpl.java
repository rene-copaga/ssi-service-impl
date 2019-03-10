package edu.umss.dip.ssiserviceimpl.repositories;

import edu.umss.dip.ssiserviceimpl.model.Activity;
import edu.umss.dip.ssiserviceimpl.model.Worker;
import org.springframework.stereotype.Repository;

import javax.persistence.StoredProcedureQuery;

@Repository
public class WorkerSPRepositoryImpl extends GenericSPRepositoryImpl<Worker> implements WorkerSPRepository {

    @Override
    protected void setParameters(StoredProcedureQuery storedProcedureQuery, Worker model) {
        storedProcedureQuery.setParameter("first_name", model.getFirstName());
        storedProcedureQuery.setParameter("last_name", model.getLastName());
        storedProcedureQuery.setParameter("hiring_date", model.getHiringDate());
        storedProcedureQuery.setParameter("rol_id", model.getRol().getId());
    }
}
