package net.thumbtack.school.hiring.request;

public class deleteEmployeeDtoRequest {

    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    private deleteEmployeeDtoRequest(String token){

        setToken(token);
    }
    public String validate(){return  "error";}
}
