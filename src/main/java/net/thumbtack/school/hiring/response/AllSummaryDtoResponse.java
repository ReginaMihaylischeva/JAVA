package net.thumbtack.school.hiring.response;

import net.thumbtack.school.hiring.Models.getSummaryResponse;

import java.util.ArrayDeque;

public class AllSummaryDtoResponse {
    private ArrayDeque<getSummaryResponse> getSummary;

    public ArrayDeque<getSummaryResponse> getRequirements() {
        return getSummary;
    }

    public void setRequirements(ArrayDeque<getSummaryResponse> getSummary) {
        this.getSummary = getSummary;
    }

    public AllSummaryDtoResponse(ArrayDeque<getSummaryResponse> getSummary) {
        setRequirements(getSummary);

    }
}
