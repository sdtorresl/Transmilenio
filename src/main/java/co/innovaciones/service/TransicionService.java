package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Transicion;
import co.innovaciones.repository.TransicionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TransicionService {

	@Autowired
	private TransicionRepository transicionRepository;

	public List<Transicion> findAll() {
		return transicionRepository.findAll();
	}

	public Optional<Transicion> findById(Integer id) {
		return transicionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Transicion save(Transicion entity) {
		return transicionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Transicion entity) {
		transicionRepository.delete(entity);
	}

}
	
