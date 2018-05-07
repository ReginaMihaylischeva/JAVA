package net.thumbtack.school.hiring.error;

public enum ServerErrorCode {

    user_already_registered("User already registered"),
    user_does_not_exist("User does not exist"),
    summary_does_not_exist("Summary does not exist"),
    vacancy_does_not_exist("Vacancy does not exist");

    private String errorString;

     ServerErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
