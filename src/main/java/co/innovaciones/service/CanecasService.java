package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Canecas;
import co.innovaciones.repository.CanecasRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CanecasService {

	@Autowired
	private CanecasRepository canecasRepository;

	public List<Canecas> findAll() {
		return canecasRepository.findAll();
	}

	public Optional<Canecas> findById(Integer id) {
		return canecasRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Canecas save(Canecas entity) {
		return canecasRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Canecas entity) {
		canecasRepository.delete(entity);
	}

}
	
