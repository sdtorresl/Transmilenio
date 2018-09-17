package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Cono;
import co.innovaciones.repository.ConoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ConoService {

	@Autowired
	private ConoRepository conoRepository;

	public List<Cono> findAll() {
		return conoRepository.findAll();
	}

	public Optional<Cono> findById(Integer id) {
		return conoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Cono save(Cono entity) {
		return conoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Cono entity) {
		conoRepository.delete(entity);
	}

}
	
