package edu.umss.dip.ssiserviceimpl.model;

import edu.umss.dip.ssiserviceimpl.dto.AsignationDto;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "createAsignation",
                procedureName = "createAsignation",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "detail_activity_id"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "worker_id")
                },
                resultClasses = Asignation.class
        ),
        @NamedStoredProcedureQuery(
                name = "readAsignation",
                procedureName = "readAsignation",
                resultClasses = Asignation.class
        ),
        @NamedStoredProcedureQuery(
                name = "updateAsignation",
                procedureName = "updateAsignation",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "detail_activity_id"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "worker_id")
                },
                resultClasses = Asignation.class
        ),
        @NamedStoredProcedureQuery(
                name = "deleteAsignation",
                procedureName = "deleteAsignation",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id")
                }
        )
})
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
