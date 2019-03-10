package edu.umss.dip.ssiserviceimpl.repositories;

import edu.umss.dip.ssiserviceimpl.model.Activity;
import edu.umss.dip.ssiserviceimpl.model.Asignation;
import org.springframework.stereotype.Repository;

import javax.persistence.StoredProcedureQuery;

@Repository
public class AsignationSPRepositoryImpl extends GenericSPRepositoryImpl<Asignation> implements AsignationSPRepository {

    @Override
    protected void setParameters(StoredProcedureQuery storedProcedureQuery, Asignation model) {
        storedProcedureQuery.setParameter("detail_activity_id", model.getDetailActivity().getId());
        storedProcedureQuery.setParameter("worker_id", model.getWorker().getId());
    }
}
