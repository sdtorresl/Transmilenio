package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Elevadora;
import co.innovaciones.repository.ElevadoraRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ElevadoraService {

	@Autowired
	private ElevadoraRepository elevadoraRepository;

	public List<Elevadora> findAll() {
		return elevadoraRepository.findAll();
	}

	public Optional<Elevadora> findById(Integer id) {
		return elevadoraRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Elevadora save(Elevadora entity) {
		return elevadoraRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Elevadora entity) {
		elevadoraRepository.delete(entity);
	}

}
	
