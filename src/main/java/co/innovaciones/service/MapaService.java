package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Mapa;
import co.innovaciones.repository.MapaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MapaService {

	@Autowired
	private MapaRepository mapaRepository;

	public List<Mapa> findAll() {
		return mapaRepository.findAll();
	}

	public Optional<Mapa> findById(Integer id) {
		return mapaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Mapa save(Mapa entity) {
		return mapaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Mapa entity) {
		mapaRepository.delete(entity);
	}

}
	
