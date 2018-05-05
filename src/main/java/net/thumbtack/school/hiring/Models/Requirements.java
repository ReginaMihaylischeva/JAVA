package net.thumbtack.school.hiring.Models;

public class Requirements {
    private String nameRequirement;
    private boolean compulsion;
    private int levelProficiency;

    public String getNameRequirement() {
        return nameRequirement;
    }

    private void setNameRequirement(String nameRequirement) {
        this.nameRequirement = nameRequirement;
    }

    public boolean isCompulsion() {
        return compulsion;
    }

    private void setCompulsion(boolean compulsion) {
        this.compulsion = compulsion;
    }

    public int getLevelProficiency() {
        return levelProficiency;
    }

    private void setLevelProficiency(int levelProficiency) {
        this.levelProficiency = levelProficiency;
    }

    public Requirements(String nameRequirement, boolean compulsion, int levelProficiency) {
        setCompulsion(compulsion);
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
