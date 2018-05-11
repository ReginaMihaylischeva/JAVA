package net.thumbtack.school.hiring.request;

public class DeleteDtoRequest {
    private String token;


    public String getToken() {
        return token;
    }

    private void setToken(String token) {
        this.token = token;
    }

    public DeleteDtoRequest(String token) {

        setToken(token);
    }

    public String validate() {
        if (token.isEmpty()) {
            return "Empty token";
        }

        return "";
    }
}
