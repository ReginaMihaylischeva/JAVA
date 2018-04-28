package net.thumbtack.school.hiring.request;

public class deleteEmployerDtoRequest {
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    private deleteEmployerDtoRequest(String token){

        setToken(token);
    }
    public String validate(){return  "error";}
}
