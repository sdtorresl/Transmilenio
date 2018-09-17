package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Corral;
import co.innovaciones.repository.CorralRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CorralService {

	@Autowired
	private CorralRepository corralRepository;

	public List<Corral> findAll() {
		return corralRepository.findAll();
	}

	public Optional<Corral> findById(Integer id) {
		return corralRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Corral save(Corral entity) {
		return corralRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Corral entity) {
		corralRepository.delete(entity);
	}

}
	
