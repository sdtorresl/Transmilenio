package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Primerauxilio;
import co.innovaciones.repository.PrimerauxilioRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PrimerauxilioService {

	@Autowired
	private PrimerauxilioRepository primerauxilioRepository;

	public List<Primerauxilio> findAll() {
		return primerauxilioRepository.findAll();
	}

	public Optional<Primerauxilio> findById(Integer id) {
		return primerauxilioRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Primerauxilio save(Primerauxilio entity) {
		return primerauxilioRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Primerauxilio entity) {
		primerauxilioRepository.delete(entity);
	}

}
	
