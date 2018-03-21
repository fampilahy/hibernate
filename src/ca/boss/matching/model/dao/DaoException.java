package ca.boss.matching.model.dao;

public class DaoException extends Exception {

	public DaoException(String message){
		super(message);
		
	}
	
	public DaoException(Throwable throwable){
		super(throwable);
		
	}
	
	public DaoException(String message , Throwable throwable){
		super(message,throwable);
	}
	
}
