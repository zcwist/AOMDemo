package exception;

public class NoSuchEntityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchEntityException(){
		super("No such entity in the entity list");
	}
	
	
}
