package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor{
	
	private RegisterNewCity registerNewCityUseCase;
	

	public RegisterNewCityInteractorImpl(final RegisterNewCity registerNewCityUseCase) {
		this.registerNewCityUseCase = registerNewCityUseCase;
	}


	@Override
	public void execute(final RegisterNewCityDto data) {
		// Convert dto to Domain
		CityDomain domain = CityDomain.create(null, null, null);
		
		
		// call use case
		registerNewCityUseCase.execute(domain);
	}

}
