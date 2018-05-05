package net.thumbtack.school.hiring.Models;

import java.util.List;

public class EditSummary {
    private List<Skills> oldSkills;
    private List<Skills> newSkills;
    private String token;

    public List<Skills> getOldSkills() {
        return oldSkills;
    }

    private void setOldSkills(List<Skills> oldSkills) {
        this.oldSkills = oldSkills;
    }

    public List<Skills> getNewSkills() {
        return newSkills;
    }

    private void setNewSkills(List<Skills> newSkills) {
        this.newSkills = newSkills;
    }

    private void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public EditSummary(List<Skills> newSkills, List<Skills> oldSkills, String token) {
        setNewSkills(newSkills);
        setOldSkills(oldSkills);
        setToken(token);
    }
}
