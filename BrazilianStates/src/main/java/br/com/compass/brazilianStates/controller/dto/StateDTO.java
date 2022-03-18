package br.com.compass.brazilianStates.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.compass.brazilianStates.model.State;
import br.com.compass.brazilianStates.model.TypeRegion;

public class StateDTO {

	private Long id;
	private String name;
	private TypeRegion region = TypeRegion.NORTE; //Get back later to explore enum parameter
	private int population;
	private String capital;
	private double area;
	
	public StateDTO(State state) {
		this.id = state.getId();
		this.name = state.getName();
		this.region = state.getRegion();
		this.population = state.getPopulation();
		this.capital = state.getCapital();
		this.area = state.getArea();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public TypeRegion getRegion() {
		return region;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public double getArea() {
		return area;
	}

	public static Page<StateDTO> convertToDto(Page<State> state) {
		return state.map(StateDTO::new);
	}
}
