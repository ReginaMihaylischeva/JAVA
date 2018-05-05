package net.thumbtack.school.hiring.response;

import net.thumbtack.school.hiring.Models.Vacancy;
import net.thumbtack.school.hiring.Models.getVacanciesResponse;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class AllVacanciesDtoResponse {
    private ArrayDeque<getVacanciesResponse> getVacancies;

    public ArrayDeque<getVacanciesResponse> getRequirements() {
        return getVacancies;
    }

    public void setRequirements(ArrayDeque<getVacanciesResponse> getVacancies) {
        this.getVacancies = getVacancies;
    }

    public AllVacanciesDtoResponse(ArrayDeque<getVacanciesResponse> getVacancies) {
        setRequirements(getVacancies);

    }
}
