package net.thumbtack.school.hiring.request;

import net.thumbtack.school.hiring.Models.Requirements;

import java.util.List;

public class GetSummaryDtoRequest {
    private List<Requirements> requirements;
    private boolean checkAllRequirements;

    public boolean isCheckAllRequirements() {
        return checkAllRequirements;
    }

    private void setCheckAllRequirements(boolean checkAllRequirements) {
        this.checkAllRequirements = checkAllRequirements;
    }

    private boolean compulsion;
    private String token;

    public boolean isCompulsion() {
        return compulsion;
    }

    private void setCompulsion(boolean compulsion) {
        this.compulsion = compulsion;
    }

    public List<Requirements> getRequirements() {
        return requirements;
    }

    private void setRequirements(List<Requirements> skills) {
        this.requirements = skills;
    }

    private void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public GetSummaryDtoRequest(List<Requirements> requirements, String token, boolean compulsion, boolean checkAllRequirements) {
        setRequirements(requirements);
        setCompulsion(compulsion);
        setToken(token);
        setCheckAllRequirements(checkAllRequirements);

    }

    public String validate() {
        for (Requirements requirements : requirements) {
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
