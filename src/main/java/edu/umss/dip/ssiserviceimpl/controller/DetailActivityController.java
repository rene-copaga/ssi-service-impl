/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.controller;

import edu.umss.dip.ssiserviceimpl.dto.DetailActivityDto;
import edu.umss.dip.ssiserviceimpl.model.DetailActivity;
import edu.umss.dip.ssiserviceimpl.service.DetailActivityService;
import edu.umss.dip.ssiserviceimpl.service.GenericService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(maxAge = 7200)
@RestController
@RequestMapping("/detailActivities")
public class DetailActivityController extends GenericController<DetailActivity, DetailActivityDto> {
    private DetailActivityService service;

    public DetailActivityController(DetailActivityService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<DetailActivityDto> getAll() {
        return super.getAll();
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}
