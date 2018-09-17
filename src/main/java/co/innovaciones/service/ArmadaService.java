package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Armada;
import co.innovaciones.repository.ArmadaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ArmadaService {

	@Autowired
	private ArmadaRepository armadaRepository;

	public List<Armada> findAll() {
		return armadaRepository.findAll();
	}

	public Optional<Armada> findById(Integer id) {
		return armadaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Armada save(Armada entity) {
		return armadaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Armada entity) {
		armadaRepository.delete(entity);
	}

}
	
