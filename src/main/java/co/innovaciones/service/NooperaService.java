package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Noopera;
import co.innovaciones.repository.NooperaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class NooperaService {

	@Autowired
	private NooperaRepository nooperaRepository;

	public List<Noopera> findAll() {
		return nooperaRepository.findAll();
	}

	public Optional<Noopera> findById(Integer id) {
		return nooperaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Noopera save(Noopera entity) {
		return nooperaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Noopera entity) {
		nooperaRepository.delete(entity);
	}

}
	
