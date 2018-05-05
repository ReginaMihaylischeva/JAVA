package net.thumbtack.school.hiring.Models;

public class AllVacancies {
    private String allVacancies;
    private String activity;

    public String getActivity() {
        return activity;
    }

    private void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAllVacancies() {
        return allVacancies;
    }

    private void setAllVacancies(String allVacancies) {
        this.allVacancies = allVacancies;
    }
    public  AllVacancies(String allVacancies ,String activity){
        setActivity(activity);
        setAllVacancies(allVacancies);
    }
}
