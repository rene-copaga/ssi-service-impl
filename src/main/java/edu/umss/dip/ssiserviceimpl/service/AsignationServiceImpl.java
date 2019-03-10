/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.service;

import edu.umss.dip.ssiserviceimpl.model.Asignation;
import edu.umss.dip.ssiserviceimpl.repositories.AsignationRepository;
import edu.umss.dip.ssiserviceimpl.repositories.GenericRepository;
import edu.umss.dip.ssiserviceimpl.repositories.GenericSPRepository;
import org.springframework.stereotype.Service;

@Service
public class AsignationServiceImpl extends GenericServiceImpl<Asignation> implements AsignationService {
    private final AsignationRepository repository;

    public AsignationServiceImpl(AsignationRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Asignation> getRepository() {
        return repository;
    }

    @Override
    protected GenericSPRepository<Asignation> getSPRepository() {
        return repository;
    }
}