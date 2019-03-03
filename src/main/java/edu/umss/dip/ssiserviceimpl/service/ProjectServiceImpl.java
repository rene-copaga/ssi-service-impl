/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.service;

import edu.umss.dip.ssiserviceimpl.model.Project;
import edu.umss.dip.ssiserviceimpl.repositories.GenericRepository;
import edu.umss.dip.ssiserviceimpl.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project> implements ProjectService {
    private final ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Project> getRepository() {
        return repository;
    }
}