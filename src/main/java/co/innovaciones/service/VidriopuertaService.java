package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Vidriopuerta;
import co.innovaciones.repository.VidriopuertaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VidriopuertaService {

	@Autowired
	private VidriopuertaRepository vidriopuertaRepository;

	public List<Vidriopuerta> findAll() {
		return vidriopuertaRepository.findAll();
	}

	public Optional<Vidriopuerta> findById(Integer id) {
		return vidriopuertaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Vidriopuerta save(Vidriopuerta entity) {
		return vidriopuertaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Vidriopuerta entity) {
		vidriopuertaRepository.delete(entity);
	}

}
	
