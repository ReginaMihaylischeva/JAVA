package net.thumbtack.school.hiring.Models;

public class Skills {
    private String nameRequirement;

    private int levelProficiency;

    public String getNameRequirement() {
        return nameRequirement;
    }

    private void setNameRequirement(String nameRequirement) {
        this.nameRequirement = nameRequirement;
    }


    public int getLevelProficiency() {
        return levelProficiency;
    }

    private void setLevelProficiency(int levelProficiency) {
        this.levelProficiency = levelProficiency;
    }

    public Skills(String nameRequirement, int levelProficiency) {
        setLevelProficiency(levelProficiency);
        setNameRequirement(nameRequirement);
    }

    public String validate() {
        if (nameRequirement.isEmpty()) {
            return "Requirement is empty";
        }
        if (levelProficiency > 6 || levelProficiency < 0) {
            return "not correct levelProficiency";
        }
        return "";
    }
}
