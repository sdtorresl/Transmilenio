package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Torniquete;
import co.innovaciones.repository.TorniqueteRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TorniqueteService {

	@Autowired
	private TorniqueteRepository torniqueteRepository;

	public List<Torniquete> findAll() {
		return torniqueteRepository.findAll();
	}

	public Optional<Torniquete> findById(Integer id) {
		return torniqueteRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Torniquete save(Torniquete entity) {
		return torniqueteRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Torniquete entity) {
		torniqueteRepository.delete(entity);
	}

}
	
