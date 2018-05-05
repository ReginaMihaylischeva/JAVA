package net.thumbtack.school.hiring.request;

public class AllVacanciesDtoRequest {
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

    public AllVacanciesDtoRequest(String allVacancies, String activity) {
        setActivity(activity);
        setAllVacancies(allVacancies);
    }

    public String validate() {
        if (!allVacancies.equals("All Vacancies")) {
            return "not correct request";
        }
        if (!(activity.equals("yes") | activity.equals("no") | activity.equals("all"))) {
            return "not correct activity";
        }
        return "";
    }
}
