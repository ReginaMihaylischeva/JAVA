package net.thumbtack.school.hiring.response;

public class RegisterEmployeeDtoResponse {
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RegisterEmployeeDtoResponse(String token) {

        setToken(token);
    }


}
