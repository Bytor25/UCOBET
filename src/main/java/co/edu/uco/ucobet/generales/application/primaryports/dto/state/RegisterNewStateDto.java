package co.edu.uco.ucobet.generales.application.primaryports.dto.state;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

public final class RegisterNewStateDto {
	
	private String name;
	
	private UUID country;

	public RegisterNewStateDto( final String name,final UUID country) {
		setName(name);
		setCountry(country);
	}

	public RegisterNewStateDto() {
		setName(TextHelper.EMPTY);
		setCountry(UUIDHelper.getDefault());
	}	

	public static final RegisterNewStateDto create(final String name, final UUID country) {
		return new RegisterNewStateDto(name, country);
	}
	

	public final String getName() {
		return name;
	}

	public final void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

	public final UUID getCountry() {
		return country;
	}

	public final void setCountry(final UUID state) {
		this.country = UUIDHelper.getDefault(state, UUIDHelper.getDefault());
	}
	

}

