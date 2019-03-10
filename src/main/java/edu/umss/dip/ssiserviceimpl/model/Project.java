package edu.umss.dip.ssiserviceimpl.model;

import edu.umss.dip.ssiserviceimpl.dto.ProjectDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "createProject",
                procedureName = "createProject",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "name"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "description")
                },
                resultClasses = Project.class
        ),
        @NamedStoredProcedureQuery(
                name = "readProject",
                procedureName = "readProject",
                resultClasses = Project.class
        ),
        @NamedStoredProcedureQuery(
                name = "updateProject",
                procedureName = "updateProject",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "name"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "description")
                },
                resultClasses = Project.class
        ),
        @NamedStoredProcedureQuery(
                name = "deleteProject",
                procedureName = "deleteProject",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id")
                }
        )
})
public class Project extends ModelBase<ProjectDto> {

    private String name;
    private String description;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<DetailActivity> detailActivities = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DetailActivity> getDetailActivities() {
        return detailActivities;
    }

    public void setDetailActivities(List<DetailActivity> detailActivities) {
        this.detailActivities = detailActivities;
    }
}
