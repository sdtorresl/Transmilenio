package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.ReStringida;
import co.innovaciones.repository.ReStringidaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ReStringidaService {

	@Autowired
	private ReStringidaRepository restringidaRepository;

	public List<ReStringida> findAll() {
		return restringidaRepository.findAll();
	}

	public Optional<ReStringida> findById(Integer id) {
		return restringidaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public ReStringida save(ReStringida entity) {
		return restringidaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(ReStringida entity) {
		restringidaRepository.delete(entity);
	}

}
	
