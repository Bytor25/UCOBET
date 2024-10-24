package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

public class UcobetException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String userMessage;
	private Layer layer;
	
	public UcobetException(final String technicalMessage,
			final String userMessager, final Layer layer,
			final Exception rootException) {
		
		super(ObjectHelper.getDefault(technicalMessage, TextHelper.applyTrim(userMessager)),
				ObjectHelper.getDefault(rootException, new Exception()));
		
		setUserMessage(userMessage);
		setLayer(layer);

	}
	
	// Create
	public static UcobetException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new DataUcobetException(technicalMessage, userMessage, rootException);
	}
	
	public static UcobetException create(final String userMessage, final Exception rootException) {
		
		return new DataUcobetException(userMessage, userMessage, rootException);
	}
	
	public static UcobetException create(final String technicalMessage, final String userMessage) {
		
		return new DataUcobetException(technicalMessage, userMessage, new Exception());
	}
	
	public static UcobetException create( final String userMessage) {
		
		return new DataUcobetException(userMessage, userMessage, new Exception());
	}
	
	
	// Mensaje de usuario
	public String getUserMessage() {
		return userMessage;
	}

	private final void setUserMessage(final String userMessage) {
		this.userMessage = TextHelper.applyTrim(userMessage);
	}
	
	
	// Layer
	public Layer getLayer() {
		return layer;
	}

	private final void setLayer(final Layer layer) {
		this.layer = ObjectHelper.getDefault(layer, Layer.GENERAL);
	}
	
	
}