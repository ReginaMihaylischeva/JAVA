package net.thumbtack.school.hiring.request;

public class AllVacanciesDtoRequest {
    private String allVacancies;

    public String getAllVacancies() {
        return allVacancies;
    }

    private void setAllVacancies(String allVacancies) {
        this.allVacancies = allVacancies;
    }
    public AllVacanciesDtoRequest(String allVacancies){
        setAllVacancies(allVacancies);
    }
    public String validate() {
        return "error";
    }
}
