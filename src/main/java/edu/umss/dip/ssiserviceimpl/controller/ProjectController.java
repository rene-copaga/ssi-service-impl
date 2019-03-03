/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.controller;

import edu.umss.dip.ssiserviceimpl.dto.ProjectDto;
import edu.umss.dip.ssiserviceimpl.model.Project;
import edu.umss.dip.ssiserviceimpl.service.GenericService;
import edu.umss.dip.ssiserviceimpl.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController extends GenericController<Project, ProjectDto> {
    private ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<ProjectDto> getAll() {
        return super.getAll();
    }

    @Override
    protected GenericService getService() {
        return service;
    }

}
