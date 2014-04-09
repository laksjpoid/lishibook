package com.lishibook.exception;

public class InternalException extends Exception{
	
	private static final long serialVersionUID = 2411696468887943053L;

	public InternalException(){
        super();
    }
	
    public InternalException(String msg){
        super(msg);
    }
}
