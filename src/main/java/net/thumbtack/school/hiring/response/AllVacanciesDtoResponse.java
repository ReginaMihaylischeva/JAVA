package net.thumbtack.school.hiring.response;

import net.thumbtack.school.hiring.Models.Vacancy;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class AllVacanciesDtoResponse {
    private ArrayList<Vacancy> requirements;

    public ArrayList<Vacancy> getRequirements() {
        return requirements;
    }

    public void setRequirements(ArrayList<Vacancy> requirements) {
        this.requirements = requirements;
    }

    public  AllVacanciesDtoResponse(ArrayList<Vacancy> requirements){
        setRequirements(requirements);

    }
}
