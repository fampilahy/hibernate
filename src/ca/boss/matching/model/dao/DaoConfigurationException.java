package ca.boss.matching.model.dao;

public class DaoConfigurationException extends Exception {

	
	
	public DaoConfigurationException(String message){
		super(message);
		
	}
	
	public DaoConfigurationException(Throwable throwable){
		super(throwable);
		
	}
	
	public DaoConfigurationException(String message , Throwable throwable){
		super(message,throwable);
		
	}
	
}
