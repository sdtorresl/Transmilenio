package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Poste;
import co.innovaciones.repository.PosteRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PosteService {

	@Autowired
	private PosteRepository posteRepository;

	public List<Poste> findAll() {
		return posteRepository.findAll();
	}

	public Optional<Poste> findById(Integer id) {
		return posteRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Poste save(Poste entity) {
		return posteRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Poste entity) {
		posteRepository.delete(entity);
	}

}
	
