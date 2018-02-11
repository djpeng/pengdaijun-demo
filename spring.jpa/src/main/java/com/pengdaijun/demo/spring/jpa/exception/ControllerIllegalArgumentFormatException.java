package com.pengdaijun.demo.spring.jpa.exception;

@SuppressWarnings("serial")
public class ControllerIllegalArgumentFormatException extends ControllerException {

	public ControllerIllegalArgumentFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public ControllerIllegalArgumentFormatException(String message) {
		super(message);
	}

	public ControllerIllegalArgumentFormatException(Throwable cause) {
		super(cause);
	}

	public ControllerIllegalArgumentFormatException() {
		super();
	}

}
