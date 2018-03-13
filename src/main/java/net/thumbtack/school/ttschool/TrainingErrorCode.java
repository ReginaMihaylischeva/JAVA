package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Wrong first name"),
    TRAINEE_WRONG_LASTNAME("Wrong last name"),
    TRAINEE_WRONG_RATING("Wrong rating");
    private String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
