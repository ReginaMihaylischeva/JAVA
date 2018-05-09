package net.thumbtack.school.hiring.response;

import net.thumbtack.school.hiring.Models.ListEmployer;

import java.util.ArrayDeque;

public class AllVacanciesDtoResponse {
    private ArrayDeque<ListEmployer> getVacancies;

    public ArrayDeque<ListEmployer> getRequirements() {
        return getVacancies;
    }

    public void setRequirements(ArrayDeque<ListEmployer> getVacancies) {
        this.getVacancies = getVacancies;
    }

    public AllVacanciesDtoResponse(ArrayDeque<ListEmployer> getVacancies) {
        setRequirements(getVacancies);

    }
}
