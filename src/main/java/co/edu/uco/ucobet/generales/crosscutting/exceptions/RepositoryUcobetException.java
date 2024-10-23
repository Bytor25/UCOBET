package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public final class RepositoryUcobetException extends UcobetException{
	
	
	private static final long serialVersionUID = 1L;

	public RepositoryUcobetException(final String technicalMessage, final String userMessager,
		 final Exception rootException) {
		super(technicalMessage, userMessager, Layer.ENTITY, rootException);
	}
	
	public static final RepositoryUcobetException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new RepositoryUcobetException(technicalMessage, userMessage, rootException);
	}
	
	public static final RepositoryUcobetException create(final String userMessage, final Exception rootException) {
		
		return new RepositoryUcobetException(userMessage, userMessage, rootException);
	}
	
	public static final RepositoryUcobetException create(final String technicalMessage, final String userMessage) {
		
		return new RepositoryUcobetException(technicalMessage, userMessage, new Exception());
	}
	
	public static final RepositoryUcobetException create( final String userMessage) {
		
		return new RepositoryUcobetException(userMessage, userMessage, new Exception());
	}

}
