package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Garita;
import co.innovaciones.repository.GaritaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GaritaService {

	@Autowired
	private GaritaRepository garitaRepository;

	public List<Garita> findAll() {
		return garitaRepository.findAll();
	}

	public Optional<Garita> findById(Integer id) {
		return garitaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Garita save(Garita entity) {
		return garitaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Garita entity) {
		garitaRepository.delete(entity);
	}

}
	
