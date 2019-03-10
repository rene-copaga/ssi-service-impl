/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.service;

import edu.umss.dip.ssiserviceimpl.model.Project;
import edu.umss.dip.ssiserviceimpl.repositories.GenericRepository;
import edu.umss.dip.ssiserviceimpl.repositories.GenericSPRepository;
import edu.umss.dip.ssiserviceimpl.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    protected GenericSPRepository<Project> getSPRepository() {
        return repository;
    }

    /*
    @Override
    public List<Project> findAll() {
        return repository.spFindAll();
    }

    @Override
    public Project save(Project model) {
        validateSave(model);
        Project t = repository.spSave(model);
        return findById(t.getId());
    }

    @Override
    public void deleteById(Long id) {
        repository.spDeleteById(id);
    }
    */
}