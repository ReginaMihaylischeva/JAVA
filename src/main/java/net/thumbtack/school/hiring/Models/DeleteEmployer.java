package net.thumbtack.school.hiring.Models;

import java.util.UUID;

public class DeleteEmployer {
    private UUID token;

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
    public DeleteEmployer(UUID token){

        setToken(token);
    }
}
