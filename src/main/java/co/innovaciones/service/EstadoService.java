package co.innovaciones.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Estado;
import co.innovaciones.repository.EstadoRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

	public Optional<Estado> findById(Integer id) {
		return estadoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Estado save(Estado entity) {
		return estadoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Estado entity) {
		estadoRepository.delete(entity);
	}

}
	
