package net.thumbtack.school.hiring.error;

public class serverException extends Exception  {
    private ServerErrorCode serverErrorCode;

    public serverException(ServerErrorCode serverErrorCode) {
        this.serverErrorCode = serverErrorCode;
    }

    public ServerErrorCode getErrorCode() {
        return serverErrorCode;
    }
}
