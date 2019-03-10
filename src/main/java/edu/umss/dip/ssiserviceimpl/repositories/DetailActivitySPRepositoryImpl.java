package edu.umss.dip.ssiserviceimpl.repositories;

import edu.umss.dip.ssiserviceimpl.model.DetailActivity;
import org.springframework.stereotype.Repository;

import javax.persistence.StoredProcedureQuery;

@Repository
public class DetailActivitySPRepositoryImpl extends GenericSPRepositoryImpl<DetailActivity> implements DetailActivitySPRepository {

    @Override
    protected void setParameters(StoredProcedureQuery storedProcedureQuery, DetailActivity model) {
        storedProcedureQuery.setParameter("activity_id", model.getActivity().getId());
        storedProcedureQuery.setParameter("project_id", model.getProject().getId());
    }
}
