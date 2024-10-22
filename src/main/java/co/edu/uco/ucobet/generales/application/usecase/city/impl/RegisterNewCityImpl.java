package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.validator.RegisterNewCityValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service // Se agrego este service
public final class RegisterNewCityImpl implements RegisterNewCity{
	
	private CityRepository cityRepository;
	private RegisterNewCityValidator newCityValidator;
	
	public RegisterNewCityImpl(final CityRepository cityRepository, final RegisterNewCityValidator newCityValidator) {
		this.cityRepository = cityRepository;
		this.newCityValidator = newCityValidator;		
	}
	
	@Override
	public void execute(final CityDomain data) {
		
		// Validar reglas de negocio
		
		// Mapper de Domain a entity
		CityEntity cityEntity = CityEntity.create();
		
		// Registrar la ciudad
		cityRepository.save(cityEntity);
		
	}

}
