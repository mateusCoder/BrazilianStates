package br.com.compass.brazilianStates.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compass.brazilianStates.controller.dto.StateDTO;
import br.com.compass.brazilianStates.controller.input.StateInput;
import br.com.compass.brazilianStates.model.State;
import br.com.compass.brazilianStates.model.TypeRegion;
import br.com.compass.brazilianStates.repository.StateRepository;

@RestController
@RequestMapping("/api/states")
public class StateController {
	
	@Autowired
	private StateRepository stateRepository;
	
	@GetMapping
	public Page<StateDTO> list(@RequestParam(required = false) TypeRegion region, 
			@PageableDefault( sort = "id", direction = Direction.ASC, size = 100) Pageable pagination){
		
		if(region == null) {
			Page<State> states = (Page<State>) stateRepository.findAll(pagination);
			return StateDTO.convertToDto(states);
		}else {
			Page<State> states = stateRepository.findByRegion(region, pagination);
			return StateDTO.convertToDto(states);
		}
	}
	
	@GetMapping("/population")
	public Page<StateDTO> listByPopulation(@PageableDefault( sort = "population", direction = Direction.DESC, size = 100) Pageable pagination){
		Page<State> states = (Page<State>) stateRepository.findAll(pagination);
		return StateDTO.convertToDto(states);
	}
	
	@GetMapping("/area")
	public Page<StateDTO> listByArea(@PageableDefault( sort = "area", direction = Direction.DESC, size = 100) Pageable pagination){
		Page<State> states = (Page<State>) stateRepository.findAll(pagination);
		return StateDTO.convertToDto(states);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<StateDTO> add(@RequestBody @Valid StateInput input, UriComponentsBuilder uriBuilder) {
		State state = input.convertToState(stateRepository);
		stateRepository.save(state);
		
		URI uri = uriBuilder.path("/states/{id}").buildAndExpand(state.getId()).toUri();
		return ResponseEntity.created(uri).body(new StateDTO(state));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StateDTO> check(@PathVariable Long id) {
		Optional<State> state = stateRepository.findById(id);
		if(state.isPresent()) {
			return ResponseEntity.ok(new StateDTO(state.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<StateDTO> update(@PathVariable @Valid Long id, @RequestBody StateInput input){
		Optional<State> optionalState = stateRepository.findById(id);
		if(optionalState.isPresent()) {
			State state = input.update(id, stateRepository);
			return ResponseEntity.ok(new StateDTO(state));
		}
		return ResponseEntity.notFound().build();	
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id){
		Optional<State> optionalState = stateRepository.findById(id);
		if(optionalState.isPresent()) {
			stateRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();	
	}
}
