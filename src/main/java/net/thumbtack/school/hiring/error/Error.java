package net.thumbtack.school.hiring.error;

public class Error {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    public Error(String error){
        setError(error);
    }
}
