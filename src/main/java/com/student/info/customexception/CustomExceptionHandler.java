package com.student.info.customexception;

public class CustomExceptionHandler extends RuntimeException {
     public CustomExceptionHandler(String msg)
     {
    	 super(msg);
     }
}
