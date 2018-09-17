package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Ventilacion;
import co.innovaciones.repository.VentilacionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VentilacionService {

	@Autowired
	private VentilacionRepository ventilacionRepository;

	public List<Ventilacion> findAll() {
		return ventilacionRepository.findAll();
	}

	public Optional<Ventilacion> findById(Integer id) {
		return ventilacionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Ventilacion save(Ventilacion entity) {
		return ventilacionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Ventilacion entity) {
		ventilacionRepository.delete(entity);
	}

}
	
