package ca.boss.matching.control;

public class CreateReferenceException extends Exception {

	
	
	public CreateReferenceException(String message){
		super(message);
		
	}
	
	public CreateReferenceException(Throwable throwable){
		super(throwable);
		
	}
	
	public CreateReferenceException(String message , Throwable throwable){
		super(message,throwable);
		
	}
	
}
