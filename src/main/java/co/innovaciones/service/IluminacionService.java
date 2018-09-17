package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Iluminacion;
import co.innovaciones.repository.IluminacionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class IluminacionService {

	@Autowired
	private IluminacionRepository iluminacionRepository;

	public List<Iluminacion> findAll() {
		return iluminacionRepository.findAll();
	}

	public Optional<Iluminacion> findById(Integer id) {
		return iluminacionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Iluminacion save(Iluminacion entity) {
		return iluminacionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Iluminacion entity) {
		iluminacionRepository.delete(entity);
	}

}
	
