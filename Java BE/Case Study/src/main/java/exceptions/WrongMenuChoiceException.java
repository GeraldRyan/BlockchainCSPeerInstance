package exceptions;

public class WrongMenuChoiceException extends Exception {
	public WrongMenuChoiceException(String errorMessage) {
		super(errorMessage);
	}
}
