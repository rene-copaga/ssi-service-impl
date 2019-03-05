package edu.umss.dip.ssiserviceimpl.dto;

import edu.umss.dip.ssiserviceimpl.model.Worker;
import org.modelmapper.ModelMapper;

import java.util.Date;

public class WorkerDto extends DtoBase<Worker> {

    private String firstName;
    private String lastName;
    private Date hiringDate;
    private Long idRol;

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

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public DtoBase toDto(Worker worker, ModelMapper mapper) {
        super.toDto(worker, mapper);

        idRol = worker.getRol().getId();

        return this;
    }
}
