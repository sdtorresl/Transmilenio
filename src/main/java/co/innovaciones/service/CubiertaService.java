package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Cubierta;
import co.innovaciones.repository.CubiertaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CubiertaService {

	@Autowired
	private CubiertaRepository cubiertaRepository;

	public List<Cubierta> findAll() {
		return cubiertaRepository.findAll();
	}

	public Optional<Cubierta> findById(Integer id) {
		return cubiertaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Cubierta save(Cubierta entity) {
		return cubiertaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Cubierta entity) {
		cubiertaRepository.delete(entity);
	}

}
	
