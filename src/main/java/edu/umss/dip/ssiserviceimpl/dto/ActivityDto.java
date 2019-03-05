package edu.umss.dip.ssiserviceimpl.dto;

import edu.umss.dip.ssiserviceimpl.model.Activity;

public class ActivityDto extends DtoBase<Activity> {

    private String activityName;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
