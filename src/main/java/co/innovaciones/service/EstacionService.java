package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;
import co.innovaciones.model.Estacion;
import co.innovaciones.repository.EstacionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EstacionService {

	@Autowired
	private EstacionRepository estacionRepository;

	public List<Estacion> findAll() {
		return estacionRepository.findAll();
	}

	public Optional<Estacion> findById(Integer id) {
		return estacionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Estacion save(Estacion entity) {
		return estacionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Estacion entity) {
		estacionRepository.delete(entity);
	}

}
