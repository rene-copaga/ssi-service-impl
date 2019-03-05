package edu.umss.dip.ssiserviceimpl.dto;

import edu.umss.dip.ssiserviceimpl.model.DetailActivity;
import org.modelmapper.ModelMapper;

public class DetailActivityDto extends DtoBase<DetailActivity> {

    private Long idActivity;
    private Long idProject;
    /*
    private Activity activity;
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
    */

    public Long getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(Long idActivity) {
        this.idActivity = idActivity;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public DtoBase toDto(DetailActivity detailActivity, ModelMapper mapper) {
        super.toDto(detailActivity, mapper);

        idActivity = detailActivity.getActivity().getId();
        idProject = detailActivity.getProject().getId();

        return this;
    }
}
