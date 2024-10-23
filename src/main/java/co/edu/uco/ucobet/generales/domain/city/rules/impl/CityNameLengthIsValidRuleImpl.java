package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameLengthIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLengthIsValidRule;

@Service
public final class CityNameLengthIsValidRuleImpl implements CityNameLengthIsValidRule{

	@Override
	public void execute(final String data) {
		
		if(!TextHelper.longitudMinima(data, 3)) {
			throw CityNameLengthIsNotValidException.create();
		}
		
		if(!TextHelper.longitudMaxima(data, 255)) {
			throw CityNameLengthIsNotValidException.create();
		}
	}

}
