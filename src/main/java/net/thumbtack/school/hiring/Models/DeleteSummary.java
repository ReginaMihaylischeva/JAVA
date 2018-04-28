package net.thumbtack.school.hiring.Models;

public class DeleteSummary {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public DeleteSummary(String token){

        setToken(token);
    }
}
