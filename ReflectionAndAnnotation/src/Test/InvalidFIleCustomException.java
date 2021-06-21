package Test;

public class InvalidFIleCustomException extends Exception {
    public InvalidFIleCustomException(String message){
        super(message + " added in constructor!");
    }
}
