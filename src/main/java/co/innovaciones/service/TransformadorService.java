package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Transformador;
import co.innovaciones.repository.TransformadorRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TransformadorService {

	@Autowired
	private TransformadorRepository transformadorRepository;

	public List<Transformador> findAll() {
		return transformadorRepository.findAll();
	}

	public Optional<Transformador> findById(Integer id) {
		return transformadorRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Transformador save(Transformador entity) {
		return transformadorRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Transformador entity) {
		transformadorRepository.delete(entity);
	}

}
	
