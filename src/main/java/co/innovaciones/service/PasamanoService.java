package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Pasamano;
import co.innovaciones.repository.PasamanoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PasamanoService {

	@Autowired
	private PasamanoRepository pasamanoRepository;

	public List<Pasamano> findAll() {
		return pasamanoRepository.findAll();
	}

	public Optional<Pasamano> findById(Integer id) {
		return pasamanoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Pasamano save(Pasamano entity) {
		return pasamanoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Pasamano entity) {
		pasamanoRepository.delete(entity);
	}

}
	
