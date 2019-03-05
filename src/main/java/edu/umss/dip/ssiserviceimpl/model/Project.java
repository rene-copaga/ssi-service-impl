package edu.umss.dip.ssiserviceimpl.model;

import edu.umss.dip.ssiserviceimpl.dto.ProjectDto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
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
