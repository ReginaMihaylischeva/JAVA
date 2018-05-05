package net.thumbtack.school.hiring.request;

public class AllSummaryDtoRequest {
    private String allSummary;

    public String getAllSummary() {
        return allSummary;
    }

    private void setAllSummary(String allSummary) {
        this.allSummary = allSummary;
    }

    public AllSummaryDtoRequest(String allSummary) {
        setAllSummary(allSummary);
    }

    public String validate() {
        if (!allSummary.equals("All summary")) {
            return "not correct request";
        }
        return "";
    }
}
