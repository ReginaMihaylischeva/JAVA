package net.thumbtack.school.hiring.request;

import net.thumbtack.school.hiring.Models.Requirements;

import java.util.List;

public class deleteVacancyDtoRequest {
    private String jobTitle;
    private int estimatedSalary;
    private List<Requirements> requirements;
    private String activity;

    public String isActivity() {
        return activity;
    }

    private void setActivity(String activity) {
        this.activity = activity;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    private void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getEstimatedSalary() {
        return estimatedSalary;
    }

    private void setEstimatedSalary(int estimatedSalary) {
        this.estimatedSalary = estimatedSalary;
    }

    public List<Requirements> getRequirements() {
        return requirements;
    }

    private void setRequirements(List<Requirements> requirements) {
        this.requirements = requirements;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    public deleteVacancyDtoRequest(String jobTitle, int estimatedSalary, String token, List<Requirements> requirements, String activity) {
        setEstimatedSalary(estimatedSalary);
        setJobTitle(jobTitle);
        setRequirements(requirements);
        setToken(token);
        setActivity(activity);

    }

    public String validate() {
        for (Requirements requirements : requirements) {
            if (!requirements.validate().equals("")) {
                return requirements.validate();
            }
        }
        if (jobTitle.isEmpty()) {
            return "Empty job title";
        }
        if (estimatedSalary < 0) {
            return "not correct estimated salary";
        }
        return "error";
    }
}
