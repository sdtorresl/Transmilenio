package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Seccion;
import co.innovaciones.repository.SeccionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SeccionService {

	@Autowired
	private SeccionRepository seccionRepository;

	public List<Seccion> findAll() {
		return seccionRepository.findAll();
	}

	public Optional<Seccion> findById(Integer id) {
		return seccionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Seccion save(Seccion entity) {
		return seccionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Seccion entity) {
		seccionRepository.delete(entity);
	}

}
	
