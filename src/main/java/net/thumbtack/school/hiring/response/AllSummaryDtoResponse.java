package net.thumbtack.school.hiring.response;

import net.thumbtack.school.hiring.Models.ListEmployee;

import java.util.ArrayDeque;

public class AllSummaryDtoResponse {
    private ArrayDeque<ListEmployee> getSummary;

    public ArrayDeque<ListEmployee> getRequirements() {
        return getSummary;
    }

    public void setRequirements(ArrayDeque<ListEmployee> getSummary) {
        this.getSummary = getSummary;
    }

    public AllSummaryDtoResponse(ArrayDeque<ListEmployee> getSummary) {
        setRequirements(getSummary);

    }
}
