package com.lishibook.exception;

public class UserExistException extends Exception{

	private static final long serialVersionUID = 3976308327506014520L;
	
	public UserExistException(){
        super();
    }
	
    public UserExistException(String msg){
        super(msg);
    }

}
