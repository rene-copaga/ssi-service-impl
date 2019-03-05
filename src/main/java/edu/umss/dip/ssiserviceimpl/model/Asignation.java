package edu.umss.dip.ssiserviceimpl.model;

import edu.umss.dip.ssiserviceimpl.dto.AsignationDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Asignation extends ModelBase<AsignationDto> {

    @ManyToOne(optional = false, targetEntity = DetailActivity.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private DetailActivity detailActivity;

    @ManyToOne(optional = false, targetEntity = Worker.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Worker worker;

    public DetailActivity getDetailActivity() {
        return detailActivity;
    }

    public void setDetailActivity(DetailActivity detailActivity) {
        this.detailActivity = detailActivity;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
