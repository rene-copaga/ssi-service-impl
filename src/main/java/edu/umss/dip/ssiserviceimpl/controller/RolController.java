/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.controller;

import edu.umss.dip.ssiserviceimpl.dto.RolDto;
import edu.umss.dip.ssiserviceimpl.model.Rol;
import edu.umss.dip.ssiserviceimpl.service.RolService;
import edu.umss.dip.ssiserviceimpl.service.GenericService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(maxAge = 7200)
@RestController
@RequestMapping("/roles")
public class RolController extends GenericController<Rol, RolDto> {
    private RolService service;

    public RolController(RolService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<RolDto> getAll() {
        return super.getAll();
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}
