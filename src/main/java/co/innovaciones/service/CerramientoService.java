package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Cerramiento;
import co.innovaciones.repository.CerramientoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CerramientoService {

	@Autowired
	private CerramientoRepository cerramientoRepository;

	public List<Cerramiento> findAll() {
		return cerramientoRepository.findAll();
	}

	public Optional<Cerramiento> findById(Integer id) {
		return cerramientoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Cerramiento save(Cerramiento entity) {
		return cerramientoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Cerramiento entity) {
		cerramientoRepository.delete(entity);
	}

}
	
