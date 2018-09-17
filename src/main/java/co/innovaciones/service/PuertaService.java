package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Puerta;
import co.innovaciones.repository.PuertaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PuertaService {

	@Autowired
	private PuertaRepository puertaRepository;

	public List<Puerta> findAll() {
		return puertaRepository.findAll();
	}

	public Optional<Puerta> findById(Integer id) {
		return puertaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Puerta save(Puerta entity) {
		return puertaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Puerta entity) {
		puertaRepository.delete(entity);
	}

}
	
