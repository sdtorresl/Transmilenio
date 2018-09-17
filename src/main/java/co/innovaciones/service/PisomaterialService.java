package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Pisomaterial;
import co.innovaciones.repository.PisomaterialRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PisomaterialService {

	@Autowired
	private PisomaterialRepository pisomaterialRepository;

	public List<Pisomaterial> findAll() {
		return pisomaterialRepository.findAll();
	}

	public Optional<Pisomaterial> findById(Integer id) {
		return pisomaterialRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Pisomaterial save(Pisomaterial entity) {
		return pisomaterialRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Pisomaterial entity) {
		pisomaterialRepository.delete(entity);
	}

}
	
