package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Compensacion;
import co.innovaciones.repository.CompensacionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CompensacionService {

	@Autowired
	private CompensacionRepository compensacionRepository;

	public List<Compensacion> findAll() {
		return compensacionRepository.findAll();
	}

	public Optional<Compensacion> findById(Integer id) {
		return compensacionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Compensacion save(Compensacion entity) {
		return compensacionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Compensacion entity) {
		compensacionRepository.delete(entity);
	}

}
	
