/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.service;

import edu.umss.dip.ssiserviceimpl.model.Activity;
import edu.umss.dip.ssiserviceimpl.repositories.ActivityRepository;
import edu.umss.dip.ssiserviceimpl.repositories.GenericRepository;
import edu.umss.dip.ssiserviceimpl.repositories.GenericSPRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl extends GenericServiceImpl<Activity> implements ActivityService {
    private final ActivityRepository repository;

    public ActivityServiceImpl(ActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Activity> getRepository() {
        return repository;
    }

    @Override
    protected GenericSPRepository<Activity> getSPRepository() {
        return repository;
    }
}