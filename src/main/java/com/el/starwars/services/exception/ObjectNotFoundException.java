package com.el.starwars.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	/**
	 * Edenilson Mendonça
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
