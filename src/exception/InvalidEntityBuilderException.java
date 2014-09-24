package exception;

@SuppressWarnings("serial")
public class InvalidEntityBuilderException extends Exception {
	public InvalidEntityBuilderException() {
		// TODO Auto-generated constructor stub
		super("No configure of the type or propertyList of the entity");
	}
}
