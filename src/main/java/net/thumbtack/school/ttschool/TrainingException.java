package net.thumbtack.school.ttschool;

public class TrainingException extends Exception {
    public TrainingErrorCode TrainingErrorCode;

    public TrainingException(TrainingErrorCode ColorErrorCode) {
        this.TrainingErrorCode = ColorErrorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return TrainingErrorCode;
    }
}
