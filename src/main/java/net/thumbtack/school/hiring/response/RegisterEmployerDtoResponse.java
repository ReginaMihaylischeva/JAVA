package net.thumbtack.school.hiring.response;

public class RegisterEmployerDtoResponse {
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RegisterEmployerDtoResponse(String token) {

        setToken(token);
    }

    public String validate() {
        return "error";
    }
}
