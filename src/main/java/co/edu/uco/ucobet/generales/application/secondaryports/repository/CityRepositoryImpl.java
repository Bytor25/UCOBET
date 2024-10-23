package co.edu.uco.ucobet.generales.application.secondaryports.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.DataUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RepositoryUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

@Repository
public class CityRepositoryImpl implements CityRepositoryCustom{
	
	private EntityManager entityManager;

	public CityRepositoryImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filter) {
		
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(CityEntity.class);
			var result = query.from(CityEntity.class);
			
			var predicates = new ArrayList<>();
			
			if(ObjectHelper.isNull(filter)) {
				
				if(!UUIDHelper.isDefault(filter.getId())) {
					predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
				}
				
				if(TextHelper.isEmpty(filter.getName())) {
					predicates.add(criteriaBuilder.equal(result.get("name"), filter.getName()));
				}
				if(!ObjectHelper.isNull(filter.getState()) && !UUIDHelper.isDefault(filter.getState().getId())) {
					predicates.add(criteriaBuilder.equal(result.get("state"), filter.getState()));
				}
			}
			
			query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
			
			return entityManager.createQuery(query).getResultList();
			
		} catch (Exception exception) {
			throw new DataUcobetException("Error", "Error", exception);
		}
	
	}
	
	@Override
	public boolean isCityBeingUsed(UUID cityId) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(Long.class);
			var root = query.from(CityEntity.class);

			query.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("id"), cityId));

			Long count = entityManager.createQuery(query).getSingleResult();

			return count > 0;

		} catch (final Exception exception) {
			throw RepositoryUcobetException.create("Error al verificar si la ciudad está siendo utilizada", null,
					exception);
		}
		
	}
	
	

}
