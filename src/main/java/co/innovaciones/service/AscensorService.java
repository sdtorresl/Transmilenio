package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Ascensor;
import co.innovaciones.repository.AscensorRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AscensorService {

	@Autowired
	private AscensorRepository ascensorRepository;

	public List<Ascensor> findAll() {
		return ascensorRepository.findAll();
	}

	public Optional<Ascensor> findById(Integer id) {
		return ascensorRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Ascensor save(Ascensor entity) {
		return ascensorRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Ascensor entity) {
		ascensorRepository.delete(entity);
	}

}
	
