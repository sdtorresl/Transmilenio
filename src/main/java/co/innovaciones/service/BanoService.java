package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Bano;
import co.innovaciones.repository.BanoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BanoService {

	@Autowired
	private BanoRepository banoRepository;

	public List<Bano> findAll() {
		return banoRepository.findAll();
	}

	public Optional<Bano> findById(Integer id) {
		return banoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Bano save(Bano entity) {
		return banoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Bano entity) {
		banoRepository.delete(entity);
	}

}
	
