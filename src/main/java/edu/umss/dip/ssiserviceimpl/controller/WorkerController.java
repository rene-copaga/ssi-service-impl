/**
 * @author: Rene D. Copaga Ch.
 */

package edu.umss.dip.ssiserviceimpl.controller;

import edu.umss.dip.ssiserviceimpl.dto.WorkerDto;
import edu.umss.dip.ssiserviceimpl.model.Worker;
import edu.umss.dip.ssiserviceimpl.service.WorkerService;
import edu.umss.dip.ssiserviceimpl.service.GenericService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController extends GenericController<Worker, WorkerDto> {
    private WorkerService service;

    public WorkerController(WorkerService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<WorkerDto> getAll() {
        return super.getAll();
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}
