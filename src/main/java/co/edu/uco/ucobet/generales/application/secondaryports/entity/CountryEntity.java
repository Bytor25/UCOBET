package co.edu.uco.ucobet.generales.application.secondaryports.entity;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Country")
public final class CountryEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "name")
	private String name;
	
	public CountryEntity(final UUID id, final String name) {
		setId(id);
		setName(name);
	}
	
	public CountryEntity() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public static final CountryEntity create() {
		return new CountryEntity();
	}
	
	
	public static final CountryEntity create(final UUID id) {
		return new CountryEntity(id, TextHelper.EMPTY);
	}
	
	public static final CountryEntity create(final UUID id, final String name) {
		return new CountryEntity(id, name);
	}
	
	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public final String getName() {
		return name;
	}

	public final void setName(final String name) {
		this.name = TextHelper.getDefault(name, TextHelper.EMPTY);
	}
	
	
}
