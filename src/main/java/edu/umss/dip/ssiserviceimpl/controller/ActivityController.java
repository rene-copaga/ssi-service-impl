/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.controller;

import edu.umss.dip.ssiserviceimpl.dto.ActivityDto;
import edu.umss.dip.ssiserviceimpl.model.Activity;
import edu.umss.dip.ssiserviceimpl.service.ActivityService;
import edu.umss.dip.ssiserviceimpl.service.GenericService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/activities")
public class ActivityController extends GenericController<Activity, ActivityDto> {
    private ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<ActivityDto> getAll() {
        return super.getAll();
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}
