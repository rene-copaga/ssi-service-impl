package edu.umss.dip.ssiserviceimpl.dto;

import edu.umss.dip.ssiserviceimpl.model.Asignation;
import org.modelmapper.ModelMapper;

public class AsignationDto extends DtoBase<Asignation> {

    private Long idDetailActivity;
    private Long idWorker;

    /*
    private DetailActivity detailActivity;
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
    */

    public Long getIdDetailActivity() {
        return idDetailActivity;
    }

    public void setIdDetailActivity(Long idDetailActivity) {
        this.idDetailActivity = idDetailActivity;
    }

    public Long getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(Long idWorker) {
        this.idWorker = idWorker;
    }

    public DtoBase toDto(Asignation asignation, ModelMapper mapper) {
        super.toDto(asignation, mapper);

        idDetailActivity = asignation.getDetailActivity().getId();
        idWorker = asignation.getWorker().getId();

        return this;
    }
}
