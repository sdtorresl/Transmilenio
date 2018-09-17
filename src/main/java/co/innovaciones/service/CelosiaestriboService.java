package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Celosiaestribo;
import co.innovaciones.repository.CelosiaestriboRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CelosiaestriboService {

	@Autowired
	private CelosiaestriboRepository celosiaestriboRepository;

	public List<Celosiaestribo> findAll() {
		return celosiaestriboRepository.findAll();
	}

	public Optional<Celosiaestribo> findById(Integer id) {
		return celosiaestriboRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Celosiaestribo save(Celosiaestribo entity) {
		return celosiaestriboRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Celosiaestribo entity) {
		celosiaestriboRepository.delete(entity);
	}

}
	
