/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.service;

import edu.umss.dip.ssiserviceimpl.model.DetailActivity;
import edu.umss.dip.ssiserviceimpl.repositories.DetailActivityRepository;
import edu.umss.dip.ssiserviceimpl.repositories.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class DetailActivityServiceImpl extends GenericServiceImpl<DetailActivity> implements DetailActivityService {
    private final DetailActivityRepository repository;

    public DetailActivityServiceImpl(DetailActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<DetailActivity> getRepository() {
        return repository;
    }
}