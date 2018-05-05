package net.thumbtack.school.hiring.Models;

public class DeleteEmployee {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DeleteEmployee(String token) {

        setToken(token);
    }
}
