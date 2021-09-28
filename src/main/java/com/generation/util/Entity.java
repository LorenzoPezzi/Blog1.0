<<<<<<< HEAD
package com.generation.util;

import java.util.Objects;

public abstract class Entity 
{

	// cosa vuol dire protected? le figlie avranno accesso a questa proprietà
	// OVUNQUE si trovino, nel package o fuori
	protected int id;

	// DUE COSTRUTTORI
	// OVERLOADING DEI COSTRUTTORI
	// OVERLOADING: più metodi con lo stesso nome nella stessa classe, ma parametri diversi
	public Entity() {}
	public Entity(int id) {this.id=id;}
	
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
	public abstract boolean isValid();
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		return id == other.id;
	}
		
	
	
=======
package com.generation.util;

import java.util.Objects;

public abstract class Entity 
{

	// cosa vuol dire protected? le figlie avranno accesso a questa proprietà
	// OVUNQUE si trovino, nel package o fuori
	protected int id;

	// DUE COSTRUTTORI
	// OVERLOADING DEI COSTRUTTORI
	// OVERLOADING: più metodi con lo stesso nome nella stessa classe, ma parametri diversi
	public Entity() {}
	public Entity(int id) {this.id=id;}
	
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
	public abstract boolean isValid();
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		return id == other.id;
	}
		
	
	
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
}