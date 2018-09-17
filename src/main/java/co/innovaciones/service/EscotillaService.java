package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Escotilla;
import co.innovaciones.repository.EscotillaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EscotillaService {

	@Autowired
	private EscotillaRepository escotillaRepository;

	public List<Escotilla> findAll() {
		return escotillaRepository.findAll();
	}

	public Optional<Escotilla> findById(Integer id) {
		return escotillaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Escotilla save(Escotilla entity) {
		return escotillaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Escotilla entity) {
		escotillaRepository.delete(entity);
	}

}
	
