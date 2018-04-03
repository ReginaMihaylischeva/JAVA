package net.thumbtack.school.ttschool;

public class TrainingException extends Exception {
    public TrainingErrorCode TrainingErrorCode;

    public TrainingException(TrainingErrorCode TrainingErrorCode) {
        this.TrainingErrorCode = TrainingErrorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return TrainingErrorCode;
    }
}
