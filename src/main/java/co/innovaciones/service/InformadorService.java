package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Informador;
import co.innovaciones.repository.InformadorRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class InformadorService {

	@Autowired
	private InformadorRepository informadorRepository;

	public List<Informador> findAll() {
		return informadorRepository.findAll();
	}

	public Optional<Informador> findById(Integer id) {
		return informadorRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Informador save(Informador entity) {
		return informadorRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Informador entity) {
		informadorRepository.delete(entity);
	}

}
	
