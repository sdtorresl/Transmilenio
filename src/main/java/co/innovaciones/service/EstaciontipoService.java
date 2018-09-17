package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Estaciontipo;
import co.innovaciones.repository.EstaciontipoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EstaciontipoService {

	@Autowired
	private EstaciontipoRepository estaciontipoRepository;

	public List<Estaciontipo> findAll() {
		return estaciontipoRepository.findAll();
	}

	public Optional<Estaciontipo> findById(Integer id) {
		return estaciontipoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Estaciontipo save(Estaciontipo entity) {
		return estaciontipoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Estaciontipo entity) {
		estaciontipoRepository.delete(entity);
	}

}
	
