package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Derivacion;
import co.innovaciones.repository.DerivacionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DerivacionService {

	@Autowired
	private DerivacionRepository derivacionRepository;

	public List<Derivacion> findAll() {
		return derivacionRepository.findAll();
	}

	public Optional<Derivacion> findById(Integer id) {
		return derivacionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Derivacion save(Derivacion entity) {
		return derivacionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Derivacion entity) {
		derivacionRepository.delete(entity);
	}

}
	
