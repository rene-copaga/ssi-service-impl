/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.controller;

import edu.umss.dip.ssiserviceimpl.dto.AsignationDto;
import edu.umss.dip.ssiserviceimpl.model.Asignation;
import edu.umss.dip.ssiserviceimpl.service.AsignationService;
import edu.umss.dip.ssiserviceimpl.service.GenericService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(maxAge = 7200)
@RestController
@RequestMapping("/asignations")
public class AsignationController extends GenericController<Asignation, AsignationDto> {
    private AsignationService service;

    public AsignationController(AsignationService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<AsignationDto> getAll() {
        return super.getAll();
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}
