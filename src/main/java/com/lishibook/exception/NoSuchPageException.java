package com.lishibook.exception;

public class NoSuchPageException extends Exception{
	
	private static final long serialVersionUID = 2530836082156246874L;
	
	public NoSuchPageException(){
        super();
    }
	
    public NoSuchPageException(String msg){
        super(msg);
    }

}
