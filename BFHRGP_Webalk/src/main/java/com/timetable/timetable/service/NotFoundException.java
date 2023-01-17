package com.timetable.timetable.service;


public class NotFoundException extends Exception {
	 
	private static final long serialVersionUID = 547517232224901611L;

	public NotFoundException() {
	    }

	    public NotFoundException(String message) {
	        super(message);
	    }

	    public NotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public NotFoundException(Throwable cause) {
	        super(cause);
	    }

	    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	        super(message, cause, enableSuppression, writableStackTrace);
	    }
}

