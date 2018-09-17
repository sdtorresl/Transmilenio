package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Plazoleta;
import co.innovaciones.repository.PlazoletaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PlazoletaService {

	@Autowired
	private PlazoletaRepository plazoletaRepository;

	public List<Plazoleta> findAll() {
		return plazoletaRepository.findAll();
	}

	public Optional<Plazoleta> findById(Integer id) {
		return plazoletaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Plazoleta save(Plazoleta entity) {
		return plazoletaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Plazoleta entity) {
		plazoletaRepository.delete(entity);
	}

}
	
