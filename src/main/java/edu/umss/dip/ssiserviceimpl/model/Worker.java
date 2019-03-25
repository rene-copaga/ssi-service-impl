package edu.umss.dip.ssiserviceimpl.model;

import edu.umss.dip.ssiserviceimpl.dto.WorkerDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "createWorker",
                procedureName = "createWorker",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "first_name"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "last_name"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "hiring_date"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "rol_id")
                },
                resultClasses = Worker.class
        ),
        @NamedStoredProcedureQuery(
                name = "readWorker",
                procedureName = "readWorker",
                resultClasses = Worker.class
        ),
        @NamedStoredProcedureQuery(
                name = "updateWorker",
                procedureName = "updateWorker",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "first_name"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "last_name"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "hiring_date"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "rol_id")
                },
                resultClasses = Worker.class
        ),
        @NamedStoredProcedureQuery(
                name = "deleteWorker",
                procedureName = "deleteWorker",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id")
                }
        )
})
public class Worker extends ModelBase<WorkerDto> {
    private String firstName;
    private String lastName;
    private Date hiringDate;

    @ManyToOne(optional = false, targetEntity = Rol.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    Rol rol;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
