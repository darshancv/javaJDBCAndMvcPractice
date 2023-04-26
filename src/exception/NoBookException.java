package exception;

public class NoBookException extends Exception {
String message="No Book Found!!";

@Override
public String getMessage() {
	// TODO Auto-generated method stub
	return message;
}

}
