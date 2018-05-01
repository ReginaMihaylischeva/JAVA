package net.thumbtack.school.hiring.request;

import java.util.List;

public class getVacanciesDtoRequest {
    private List<Skills> skills;
    private boolean compulsion;
    private String token;
    private boolean  checkAllSkills;


    public boolean isCheckAllSkills() {
        return checkAllSkills;
    }

    private void setCheckAllSkills(boolean checkAllSkills) {
        this.checkAllSkills = checkAllSkills;
    }
    public boolean isCompulsion() {
        return compulsion;
    }

    private void setCompulsion(boolean compulsion) {
        this.compulsion = compulsion;
    }

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

    public getVacanciesDtoRequest(List<Skills> skills, String token,boolean compulsion) {
        setSkills(skills);
        setCompulsion(compulsion);
        setToken(token);
        setCheckAllSkills(checkAllSkills);

    }
    public String validate() {
        return "error";
    }
}
