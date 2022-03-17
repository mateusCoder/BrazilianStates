package br.com.compass.brazilianStates.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compass.brazilianStates.model.State;
import br.com.compass.brazilianStates.model.TypeRegion;

@RestController
public class StateController {
	
	@RequestMapping("/states")
	public List<State> list(){
		State state = new State("Rio Grande do Norte", TypeRegion.NORDESTE, 3409000, "Natal", 52.797);
		
		return Arrays.asList(state);
	}
}
