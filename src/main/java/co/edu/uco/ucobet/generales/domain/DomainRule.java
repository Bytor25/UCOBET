package co.edu.uco.ucobet.generales.domain;

import org.springframework.stereotype.Service;

@Service // Se agrega este Service
public interface DomainRule<T> {
	
	void execute(T data);
}
