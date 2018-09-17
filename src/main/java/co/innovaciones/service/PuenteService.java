package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Puente;
import co.innovaciones.repository.PuenteRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PuenteService {

	@Autowired
	private PuenteRepository puenteRepository;

	public List<Puente> findAll() {
		return puenteRepository.findAll();
	}

	public Optional<Puente> findById(Integer id) {
		return puenteRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Puente save(Puente entity) {
		return puenteRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Puente entity) {
		puenteRepository.delete(entity);
	}

}
	
