package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Variador;
import co.innovaciones.repository.VariadorRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VariadorService {

	@Autowired
	private VariadorRepository variadorRepository;

	public List<Variador> findAll() {
		return variadorRepository.findAll();
	}

	public Optional<Variador> findById(Integer id) {
		return variadorRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Variador save(Variador entity) {
		return variadorRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Variador entity) {
		variadorRepository.delete(entity);
	}

}
	
