package net.thumbtack.school.hiring.Models;

import net.thumbtack.school.hiring.request.Skills;

import java.util.List;

public class getVacancies {
    private List<Skills> skills;

    public boolean isCheckAllSkills() {
        return checkAllSkills;
    }

    private void setCheckAllSkills(boolean checkAllSkills) {
        this.checkAllSkills = checkAllSkills;
    }

    private boolean compulsion;
    private String token;
    private boolean  checkAllSkills;

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

    public getVacancies(List<Skills> skills, String token,boolean compulsion,boolean checkAllSkills) {
        setSkills(skills);
        setCompulsion(compulsion);
        setToken(token);
        setCheckAllSkills(checkAllSkills);
    }
}
