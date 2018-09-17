package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Puertatroncal;
import co.innovaciones.repository.PuertatroncalRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PuertatroncalService {

	@Autowired
	private PuertatroncalRepository puertatroncalRepository;

	public List<Puertatroncal> findAll() {
		return puertatroncalRepository.findAll();
	}

	public Optional<Puertatroncal> findById(Integer id) {
		return puertatroncalRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Puertatroncal save(Puertatroncal entity) {
		return puertatroncalRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Puertatroncal entity) {
		puertatroncalRepository.delete(entity);
	}

}
	
