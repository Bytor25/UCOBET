package co.edu.uco.ucobet.generales.domain.state;

import java.util.UUID;

import co.edu.uco.ucobet.generales.domain.Domain;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;

public final class StateDomain extends Domain {
	
	private String name;
	private CountryDomain country;

	private StateDomain(final UUID id, final String name,final CountryDomain country ) {
		super(id);
		setName(name);
		setCountry(country);
	}
	
	public static final StateDomain create(final UUID id, final String name, final CountryDomain country) {
		return new StateDomain(id,name,country);
	}
	
	// Name
	public final  String getName() {
		return name;
	}

	private final void setName(final String name) {
		this.name = name;
	}
	
	// Country
	public final CountryDomain getCountry() {
		return country;
	}

	private final void setCountry(final CountryDomain country) {
		this.country = country;
	}
	
}