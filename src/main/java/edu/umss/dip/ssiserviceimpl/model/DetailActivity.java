package edu.umss.dip.ssiserviceimpl.model;

import edu.umss.dip.ssiserviceimpl.dto.DetailActivityDto;
import edu.umss.dip.ssiserviceimpl.dto.DtoBase;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "createDetailActivity",
                procedureName = "createDetailActivity",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "activity_id"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "project_id")
                },
                resultClasses = DetailActivity.class
        ),
        @NamedStoredProcedureQuery(
                name = "readDetailActivity",
                procedureName = "readDetailActivity",
                resultClasses = DetailActivity.class
        ),
        @NamedStoredProcedureQuery(
                name = "updateDetailActivity",
                procedureName = "updateDetailActivity",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "activity_id"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "project_id")
                },
                resultClasses = DetailActivity.class
        ),
        @NamedStoredProcedureQuery(
                name = "deleteDetailActivity",
                procedureName = "deleteDetailActivity",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id")
                }
        )
})
public class DetailActivity extends ModelBase<DetailActivityDto> {

    @ManyToOne(optional = false, targetEntity = Activity.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Activity activity;

    @ManyToOne(optional = false, targetEntity = Project.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
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

    @Override
    public String toString() {
        return activity.toString() + project.toString();
    }
}
