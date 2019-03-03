package edu.umss.dip.ssiserviceimpl.dto;

import edu.umss.dip.ssiserviceimpl.model.Project;

public class ProjectDto extends DtoBase<Project> {
    private String name;
    private String description;

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
}
