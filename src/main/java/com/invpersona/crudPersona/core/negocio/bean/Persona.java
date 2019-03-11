package com.invpersona.crudPersona.core.negocio.bean;

public class Persona {
 public Long  personaId;
 public String name;
 public Long height;
 public Double mass;
 public String hairColor;
 public String gender;	
 public String planet;
 

public Long getPersonaId() {
	return personaId;
}
public void setPersonaId(Long personaId) {
	this.personaId = personaId;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getHeight() {
	return height;
}
public void setHeight(Long height) {
	this.height = height;
}
public Double getMass() {
	return mass;
}
public void setMass(Double mass) {
	this.mass = mass;
}
public String getHairColor() {
	return hairColor;
}
public void setHairColor(String hairColor) {
	this.hairColor = hairColor;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPlanet() {
	return planet;
}
public void setPlanet(String planet) {
	this.planet = planet;
}
 
 
}
