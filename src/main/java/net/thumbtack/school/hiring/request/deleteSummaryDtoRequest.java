package net.thumbtack.school.hiring.request;

public class deleteSummaryDtoRequest {
    private String machineLanguage;
    private int rating;
    private String token;

    public int getRating() {
        return rating;
    }

    private void setRating(int rating) {
        this.rating = rating;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public deleteSummaryDtoRequest(String machineLanguage, int rating, String token) {
        setRating(rating);
        setMachineLanguage(machineLanguage);

        setToken(token);
    }


    private void setMachineLanguage(String machineLanguage) {
        this.machineLanguage = machineLanguage;
    }


    public String getMachineLanguage() {
        return machineLanguage;
    }


    public String validate() {
        return "error";
    }
}
