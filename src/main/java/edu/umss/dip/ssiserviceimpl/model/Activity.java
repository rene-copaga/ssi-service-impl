package edu.umss.dip.ssiserviceimpl.model;

import edu.umss.dip.ssiserviceimpl.dto.ActivityDto;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "createActivity",
                procedureName = "createActivity",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "activity_name")
                },
                resultClasses = Activity.class
        ),
        @NamedStoredProcedureQuery(
                name = "readActivity",
                procedureName = "readActivity",
                resultClasses = Activity.class
        ),
        @NamedStoredProcedureQuery(
                name = "updateActivity",
                procedureName = "updateActivity",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "activity_name")
                },
                resultClasses = Activity.class
        ),
        @NamedStoredProcedureQuery(
                name = "deleteActivity",
                procedureName = "deleteActivity",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "id")
                }
        )
})
public class Activity extends ModelBase<ActivityDto> {

    private String activityName;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
