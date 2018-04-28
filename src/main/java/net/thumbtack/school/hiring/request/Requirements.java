package net.thumbtack.school.hiring.request;

public class Requirements {
    private String  nameRequirement;
    private boolean compulsion;

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

    private int levelProficiency;
    public Requirements(String nameRequirement,boolean compulsion, int levelProficiency){
        setCompulsion(compulsion);
        setLevelProficiency(levelProficiency);
        setNameRequirement(nameRequirement);
    }
}
