package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Carpa;
import co.innovaciones.repository.CarpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CarpaService {

	@Autowired
	private CarpaRepository carpaRepository;

	public List<Carpa> findAll() {
		return carpaRepository.findAll();
	}

	public Optional<Carpa> findById(Integer id) {
		return carpaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Carpa save(Carpa entity) {
		return carpaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Carpa entity) {
		carpaRepository.delete(entity);
	}

}
	
