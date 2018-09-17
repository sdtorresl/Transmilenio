package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Estribo;
import co.innovaciones.repository.EstriboRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EstriboService {

	@Autowired
	private EstriboRepository estriboRepository;

	public List<Estribo> findAll() {
		return estriboRepository.findAll();
	}

	public Optional<Estribo> findById(Integer id) {
		return estriboRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Estribo save(Estribo entity) {
		return estriboRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Estribo entity) {
		estriboRepository.delete(entity);
	}

}
	
