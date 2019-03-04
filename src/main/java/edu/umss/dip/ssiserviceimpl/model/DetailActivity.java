package edu.umss.dip.ssiserviceimpl.model;

import edu.umss.dip.ssiserviceimpl.dto.DetailActivityDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class DetailActivity extends ModelBase<DetailActivityDto> {

    @ManyToOne(optional = false, targetEntity = Activity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Activity activity;

    @ManyToOne(optional = false, targetEntity = Project.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Project project;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
