package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.city;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucobet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

@RestController
@RequestMapping("/generales/api/v1/cities")
public class RegisterNewCityController {
	
	private RegisterNewCityInteractor registerNewCityinteractor;
	
	public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityinteractor) {
		this.registerNewCityinteractor = registerNewCityinteractor;
	}

	@GetMapping
	public RegisterNewCityDto getDummy() {
		return RegisterNewCityDto.create("Rionegro", UUIDHelper.getDefault());
	}
	
	@PostMapping
	public RegisterNewCityDto getDummy(@RequestBody RegisterNewCityDto data) {
		registerNewCityinteractor.execute(data);
		return data;
	}
}
