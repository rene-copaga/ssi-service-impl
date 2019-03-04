/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.service;

import edu.umss.dip.ssiserviceimpl.model.Rol;
import edu.umss.dip.ssiserviceimpl.repositories.RolRepository;
import edu.umss.dip.ssiserviceimpl.repositories.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol> implements RolService {
    private final RolRepository repository;

    public RolServiceImpl(RolRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Rol> getRepository() {
        return repository;
    }
}