package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Altavoz;
import co.innovaciones.repository.AltavozRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AltavozService {

	@Autowired
	private AltavozRepository altavozRepository;

	public List<Altavoz> findAll() {
		return altavozRepository.findAll();
	}

	public Optional<Altavoz> findById(Integer id) {
		return altavozRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Altavoz save(Altavoz entity) {
		return altavozRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Altavoz entity) {
		altavozRepository.delete(entity);
	}

}
	
