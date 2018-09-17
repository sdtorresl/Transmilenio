package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Toma;
import co.innovaciones.repository.TomaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TomaService {

	@Autowired
	private TomaRepository tomaRepository;

	public List<Toma> findAll() {
		return tomaRepository.findAll();
	}

	public Optional<Toma> findById(Integer id) {
		return tomaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Toma save(Toma entity) {
		return tomaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Toma entity) {
		tomaRepository.delete(entity);
	}

}
	
