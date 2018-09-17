package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Evacuacion;
import co.innovaciones.repository.EvacuacionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EvacuacionService {

	@Autowired
	private EvacuacionRepository evacuacionRepository;

	public List<Evacuacion> findAll() {
		return evacuacionRepository.findAll();
	}

	public Optional<Evacuacion> findById(Integer id) {
		return evacuacionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Evacuacion save(Evacuacion entity) {
		return evacuacionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Evacuacion entity) {
		evacuacionRepository.delete(entity);
	}

}
	
