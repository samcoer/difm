package com.cerebsoft.fw.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<String> errorMsgs = new ArrayList<String>();

	public BusinessException() {

		super();
	}

	public BusinessException(String message) {

		super(message);
	}

	public BusinessException(List<String> messages) {

		super();
		errorMsgs = messages;
	}

	public BusinessException(String message, Throwable cause) {

		super(message, cause);
	}

	public BusinessException(Exception e) {

		super(e);
	}

	public List<String> getErrorMsgs() {

		// errorMsgs.add(this.getMessage());
		return errorMsgs;
	}

	public void setErrorMsgs(List<String> errorMsgs) {

		this.errorMsgs = errorMsgs;
	}
}
