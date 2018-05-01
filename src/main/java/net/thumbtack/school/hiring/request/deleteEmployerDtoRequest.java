package net.thumbtack.school.hiring.request;

import java.util.UUID;

public class deleteEmployerDtoRequest {
    private UUID token;


    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
    private deleteEmployerDtoRequest(UUID token){

        setToken(token);
    }
    public String validate(){return  "error";}
}
