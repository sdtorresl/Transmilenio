package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Incendio;
import co.innovaciones.repository.IncendioRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class IncendioService {

	@Autowired
	private IncendioRepository incendioRepository;

	public List<Incendio> findAll() {
		return incendioRepository.findAll();
	}

	public Optional<Incendio> findById(Integer id) {
		return incendioRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Incendio save(Incendio entity) {
		return incendioRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Incendio entity) {
		incendioRepository.delete(entity);
	}

}
	
