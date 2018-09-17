package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Corredor;
import co.innovaciones.repository.CorredorRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CorredorService {

	@Autowired
	private CorredorRepository corredorRepository;

	public List<Corredor> findAll() {
		return corredorRepository.findAll();
	}

	public Optional<Corredor> findById(Integer id) {
		return corredorRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Corredor save(Corredor entity) {
		return corredorRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Corredor entity) {
		corredorRepository.delete(entity);
	}

}
	
