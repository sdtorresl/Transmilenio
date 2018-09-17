package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Seccionestacion;
import co.innovaciones.repository.SeccionestacionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SeccionestacionService {

	@Autowired
	private SeccionestacionRepository seccionestacionRepository;

	public List<Seccionestacion> findAll() {
		return seccionestacionRepository.findAll();
	}

	public Optional<Seccionestacion> findById(Integer id) {
		return seccionestacionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Seccionestacion save(Seccionestacion entity) {
		return seccionestacionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Seccionestacion entity) {
		seccionestacionRepository.delete(entity);
	}

}
	
