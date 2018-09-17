package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Vidrio;
import co.innovaciones.repository.VidrioRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VidrioService {

	@Autowired
	private VidrioRepository vidrioRepository;

	public List<Vidrio> findAll() {
		return vidrioRepository.findAll();
	}

	public Optional<Vidrio> findById(Integer id) {
		return vidrioRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Vidrio save(Vidrio entity) {
		return vidrioRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Vidrio entity) {
		vidrioRepository.delete(entity);
	}

}
	
