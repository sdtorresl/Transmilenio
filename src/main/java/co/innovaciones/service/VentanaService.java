package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Ventana;
import co.innovaciones.repository.VentanaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VentanaService {

	@Autowired
	private VentanaRepository ventanaRepository;

	public List<Ventana> findAll() {
		return ventanaRepository.findAll();
	}

	public Optional<Ventana> findById(Integer id) {
		return ventanaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Ventana save(Ventana entity) {
		return ventanaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Ventana entity) {
		ventanaRepository.delete(entity);
	}

}
	
