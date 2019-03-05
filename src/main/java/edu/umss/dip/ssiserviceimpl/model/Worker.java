package edu.umss.dip.ssiserviceimpl.model;

import edu.umss.dip.ssiserviceimpl.dto.WorkerDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
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
