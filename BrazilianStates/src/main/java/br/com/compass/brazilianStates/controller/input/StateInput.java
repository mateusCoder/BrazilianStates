package br.com.compass.brazilianStates.controller.input;

import br.com.compass.brazilianStates.model.State;
import br.com.compass.brazilianStates.model.TypeRegion;
import br.com.compass.brazilianStates.repository.StateRepository;

public class StateInput {
	
	private String name;
	private TypeRegion region = TypeRegion.NORTE; //Get back later to explore enum parameter
	private int population;
	private String capital;
	private double area;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public TypeRegion getRegion() {
		return region;
	}
	
	public void setRegion(TypeRegion region) {
		this.region = region;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	public double getArea() {
		return area;
	}
	
	public void setArea(double area) {
		this.area = area;
	}

	public State convertToState(StateRepository repository) {
		State state = repository.findByName(name);
		return new State(name, region, population, capital, area);
	} 
	
	
}
