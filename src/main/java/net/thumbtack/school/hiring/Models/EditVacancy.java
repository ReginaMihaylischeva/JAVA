package net.thumbtack.school.hiring.Models;

import java.util.List;

public class EditVacancy {
    private List<Requirements> oldRequirements;
    private List<Requirements> newRequirements;

    private String token;

    public List<Requirements> getOldRequirements() {
        return oldRequirements;
    }

    private void setOldRequirements(List<Requirements> oldRequirements) {
        this.oldRequirements = oldRequirements;
    }

    public List<Requirements> getNewRequirements() {
        return newRequirements;
    }

    private void setNewRequirements(List<Requirements> newRequirements) {
        this.newRequirements = newRequirements;
    }

    private void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public EditVacancy(List<Requirements> newRequirements, List<Requirements> oldRequirements, String token) {
        setNewRequirements(newRequirements);
        setOldRequirements(oldRequirements);
        setToken(token);
    }
}
