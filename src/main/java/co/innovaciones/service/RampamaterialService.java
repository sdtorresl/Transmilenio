package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Rampamaterial;
import co.innovaciones.repository.RampamaterialRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RampamaterialService {

	@Autowired
	private RampamaterialRepository rampamaterialRepository;

	public List<Rampamaterial> findAll() {
		return rampamaterialRepository.findAll();
	}

	public Optional<Rampamaterial> findById(Integer id) {
		return rampamaterialRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Rampamaterial save(Rampamaterial entity) {
		return rampamaterialRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Rampamaterial entity) {
		rampamaterialRepository.delete(entity);
	}

}
	
