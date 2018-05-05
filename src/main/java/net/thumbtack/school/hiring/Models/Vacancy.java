package net.thumbtack.school.hiring.Models;

import java.util.List;

public class Vacancy {
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

    public Vacancy(String jobTitle, int estimatedSalary, String token, List<Requirements> requirements, String activity) {
        setEstimatedSalary(estimatedSalary);
        setJobTitle(jobTitle);
        setRequirements(requirements);
        setToken(token);
        setActivity(activity);

    }
}
