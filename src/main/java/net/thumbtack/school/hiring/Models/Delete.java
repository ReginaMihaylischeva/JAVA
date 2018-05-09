package net.thumbtack.school.hiring.Models;

public class Delete {
    private String token;


    public String getToken() {
        return token;
    }

    private void setToken(String token) {
        this.token = token;
    }

    public Delete(String token) {

        setToken(token);
    }
}
