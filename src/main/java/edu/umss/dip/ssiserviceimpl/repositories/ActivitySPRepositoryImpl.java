package edu.umss.dip.ssiserviceimpl.repositories;

import edu.umss.dip.ssiserviceimpl.model.Activity;
import edu.umss.dip.ssiserviceimpl.model.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.StoredProcedureQuery;

@Repository
public class ActivitySPRepositoryImpl extends GenericSPRepositoryImpl<Activity> implements ActivitySPRepository {

    @Override
    protected void setParameters(StoredProcedureQuery storedProcedureQuery, Activity model) {
        storedProcedureQuery.setParameter("activity_name", model.getActivityName());
    }
}
