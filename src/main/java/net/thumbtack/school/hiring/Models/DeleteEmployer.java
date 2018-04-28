package net.thumbtack.school.hiring.Models;

public class DeleteEmployer {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public DeleteEmployer(String token){

        setToken(token);
    }
}
