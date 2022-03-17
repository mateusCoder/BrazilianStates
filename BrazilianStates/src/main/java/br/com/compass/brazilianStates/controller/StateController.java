package br.com.compass.brazilianStates.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compass.brazilianStates.controller.dto.StateDTO;
import br.com.compass.brazilianStates.model.State;
import br.com.compass.brazilianStates.model.TypeRegion;
import br.com.compass.brazilianStates.repository.StateRepository;

@RestController
@RequestMapping("/states")
public class StateController {
	
	@Autowired
	private StateRepository stateRepository;
	
	@GetMapping
	public List<StateDTO> list(TypeRegion region){	
		
		if(region == null) {
			List<State> states = stateRepository.findAll();
			return StateDTO.convertToDto(states);
		}else {
			List<State> states = stateRepository.findByRegion(region);
			return StateDTO.convertToDto(states);
		}
	}
}
