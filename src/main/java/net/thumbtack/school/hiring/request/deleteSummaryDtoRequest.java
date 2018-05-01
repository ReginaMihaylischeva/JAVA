package net.thumbtack.school.hiring.request;

import java.util.List;

public class deleteSummaryDtoRequest {
    private List<Skills> skills;

    private String token;

    public List<Skills> getSkills() {
        return skills;
    }

    private void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    private void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public deleteSummaryDtoRequest(List<Skills> skills, String token) {
        setSkills(skills);

        setToken(token);
    }


    public String validate() {
        return "error";
    }
}
