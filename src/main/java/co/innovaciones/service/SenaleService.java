package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Senale;
import co.innovaciones.repository.SenaleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SenaleService {

	@Autowired
	private SenaleRepository senaleRepository;

	public List<Senale> findAll() {
		return senaleRepository.findAll();
	}

	public Optional<Senale> findById(Integer id) {
		return senaleRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Senale save(Senale entity) {
		return senaleRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Senale entity) {
		senaleRepository.delete(entity);
	}

}
	
