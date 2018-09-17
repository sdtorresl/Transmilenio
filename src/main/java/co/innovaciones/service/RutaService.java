package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Ruta;
import co.innovaciones.repository.RutaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RutaService {

	@Autowired
	private RutaRepository rutaRepository;

	public List<Ruta> findAll() {
		return rutaRepository.findAll();
	}

	public Optional<Ruta> findById(Integer id) {
		return rutaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Ruta save(Ruta entity) {
		return rutaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Ruta entity) {
		rutaRepository.delete(entity);
	}

}
	
