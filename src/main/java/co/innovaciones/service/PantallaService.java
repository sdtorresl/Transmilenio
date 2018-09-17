package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Pantalla;
import co.innovaciones.repository.PantallaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PantallaService {

	@Autowired
	private PantallaRepository pantallaRepository;

	public List<Pantalla> findAll() {
		return pantallaRepository.findAll();
	}

	public Optional<Pantalla> findById(Integer id) {
		return pantallaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Pantalla save(Pantalla entity) {
		return pantallaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Pantalla entity) {
		pantallaRepository.delete(entity);
	}

}
	
