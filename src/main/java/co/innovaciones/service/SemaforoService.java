package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Semaforo;
import co.innovaciones.repository.SemaforoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SemaforoService {

	@Autowired
	private SemaforoRepository semaforoRepository;

	public List<Semaforo> findAll() {
		return semaforoRepository.findAll();
	}

	public Optional<Semaforo> findById(Integer id) {
		return semaforoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Semaforo save(Semaforo entity) {
		return semaforoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Semaforo entity) {
		semaforoRepository.delete(entity);
	}

}
	
