package net.thumbtack.school.hiring.Models;

import javafx.scene.control.Skin;
import net.thumbtack.school.hiring.request.Skills;

import java.util.List;
import java.util.Set;

public class Summary {
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

    public Summary(List<Skills> skills, String token) {
        setSkills(skills);

        setToken(token);
    }


}
