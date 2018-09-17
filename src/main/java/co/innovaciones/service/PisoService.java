package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Piso;
import co.innovaciones.repository.PisoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PisoService {

	@Autowired
	private PisoRepository pisoRepository;

	public List<Piso> findAll() {
		return pisoRepository.findAll();
	}

	public Optional<Piso> findById(Integer id) {
		return pisoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Piso save(Piso entity) {
		return pisoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Piso entity) {
		pisoRepository.delete(entity);
	}

}
	
