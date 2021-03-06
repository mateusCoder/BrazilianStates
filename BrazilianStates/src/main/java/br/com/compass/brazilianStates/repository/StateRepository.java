package br.com.compass.brazilianStates.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compass.brazilianStates.model.State;
import br.com.compass.brazilianStates.model.TypeRegion;

public interface StateRepository  extends JpaRepository<State, Long>{
	Page<State> findByRegion(TypeRegion region, Pageable pagination);

	State findByName(String name);
}
