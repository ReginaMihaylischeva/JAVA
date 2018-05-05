package net.thumbtack.school.hiring.request;

import net.thumbtack.school.hiring.Models.Requirements;

import java.util.List;

public class EditVacancyDtoRequest {
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

    public EditVacancyDtoRequest(List<Requirements> newRequirements, List<Requirements> oldRequirements, String token) {
        setNewRequirements(newRequirements);
        setOldRequirements(oldRequirements);
        setToken(token);
    }

    public String validate() {
        for (Requirements requirements : oldRequirements) {
            if (!requirements.validate().equals("")) {
                return requirements.validate();
            }
        }
        for (Requirements requirements : newRequirements) {
            if (!requirements.validate().equals("")) {
                return requirements.validate();
            }
        }
        if (token.isEmpty()) {
            return "Empty token";
        }
        return "";
    }
}
