package com.lishibook.exception;

public class PermissionException extends Exception{
	
	private static final long serialVersionUID = -3499374830669952088L;

	public PermissionException(){
        super();
    }
	
    public PermissionException(String msg){
        super(msg);
    }

}
