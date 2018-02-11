package com.pengdaijun.demo.spring.jpa.exception;

public abstract class ControllerException extends RuntimeException {
	private static final long serialVersionUID = 8366876402514505863L;

	public ControllerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ControllerException(String message) {
		super(message);
	}

	public ControllerException(Throwable cause) {
		super(cause);
	}

	public ControllerException() {
		super();
	}
}
