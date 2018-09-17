package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Silla;
import co.innovaciones.repository.SillaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SillaService {

	@Autowired
	private SillaRepository sillaRepository;

	public List<Silla> findAll() {
		return sillaRepository.findAll();
	}

	public Optional<Silla> findById(Integer id) {
		return sillaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Silla save(Silla entity) {
		return sillaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Silla entity) {
		sillaRepository.delete(entity);
	}

}
	
