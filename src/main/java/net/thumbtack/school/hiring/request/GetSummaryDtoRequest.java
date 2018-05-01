package net.thumbtack.school.hiring.request;

public class GetSummaryDtoRequest {
    private String  nameRequirement;
    private int levelProficiency;

    public boolean isCompulsion() {
        return compulsion;
    }

    private void setCompulsion(boolean compulsion) {
        this.compulsion = compulsion;
    }

    private boolean compulsion;
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

    public GetSummaryDtoRequest(String nameRequirement, int levelProficiency,boolean compulsion){
        setCompulsion(compulsion);
        setLevelProficiency(levelProficiency);
        setNameRequirement(nameRequirement);
    }
    public String validate(){return  "error";}
}
