package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Ducto;
import co.innovaciones.repository.DuctoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DuctoService {

	@Autowired
	private DuctoRepository ductoRepository;

	public List<Ducto> findAll() {
		return ductoRepository.findAll();
	}

	public Optional<Ducto> findById(Integer id) {
		return ductoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Ducto save(Ducto entity) {
		return ductoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Ducto entity) {
		ductoRepository.delete(entity);
	}

}
	
