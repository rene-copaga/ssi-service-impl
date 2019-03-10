package edu.umss.dip.ssiserviceimpl.model;

import edu.umss.dip.ssiserviceimpl.dto.RolDto;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "createRol",
                procedureName = "createRol",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "name")
                },
                resultClasses = Rol.class
        ),
        @NamedStoredProcedureQuery(
                name = "readRol",
                procedureName = "readRol",
                resultClasses = Rol.class
        ),
        @NamedStoredProcedureQuery(
                name = "updateRol",
                procedureName = "updateRol",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "name")
                },
                resultClasses = Rol.class
        ),
        @NamedStoredProcedureQuery(
                name = "deleteRol",
                procedureName = "deleteRol",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id")
                }
        )
})
public class Rol extends ModelBase<RolDto> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
