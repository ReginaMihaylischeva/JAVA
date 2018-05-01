package net.thumbtack.school.hiring.response;

import net.thumbtack.school.hiring.Models.Vacancy;
import net.thumbtack.school.hiring.request.Requirements;

import java.util.ArrayDeque;
import java.util.List;

public class GetVacansiesDtoResponse {

    private ArrayDeque<Vacancy> requirements;

    public ArrayDeque<Vacancy> getRequirements() {
        return requirements;
    }

    public void setRequirements(ArrayDeque<Vacancy> requirements) {
        this.requirements = requirements;
    }

    public  GetVacansiesDtoResponse(ArrayDeque<Vacancy> requirements){
       setRequirements(requirements);

    }
}
