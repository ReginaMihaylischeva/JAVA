package net.thumbtack.school.hiring.Models;

public class AllVacancies {
    private String allVacancies;

    public String getAllVacancies() {
        return allVacancies;
    }

    private void setAllVacancies(String allVacancies) {
        this.allVacancies = allVacancies;
    }
    public  AllVacancies(String allVacancies){
        setAllVacancies(allVacancies);
    }
}
