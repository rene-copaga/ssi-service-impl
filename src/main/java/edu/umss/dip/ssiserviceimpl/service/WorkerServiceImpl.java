/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.service;

import edu.umss.dip.ssiserviceimpl.model.Worker;
import edu.umss.dip.ssiserviceimpl.repositories.WorkerRepository;
import edu.umss.dip.ssiserviceimpl.repositories.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl extends GenericServiceImpl<Worker> implements WorkerService {
    private final WorkerRepository repository;

    public WorkerServiceImpl(WorkerRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Worker> getRepository() {
        return repository;
    }
}