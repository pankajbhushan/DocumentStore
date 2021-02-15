package com.bitnbytes.documentstore.exception;

public class DocumentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6052438353706256452L;

	public DocumentNotFoundException() {}
	
	public DocumentNotFoundException(String message) {
		super(message);
	}
}
