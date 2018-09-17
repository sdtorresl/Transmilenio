package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Planta;
import co.innovaciones.repository.PlantaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PlantaService {

	@Autowired
	private PlantaRepository plantaRepository;

	public List<Planta> findAll() {
		return plantaRepository.findAll();
	}

	public Optional<Planta> findById(Integer id) {
		return plantaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Planta save(Planta entity) {
		return plantaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Planta entity) {
		plantaRepository.delete(entity);
	}

}
	
