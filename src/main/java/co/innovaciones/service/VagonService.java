package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Vagon;
import co.innovaciones.repository.VagonRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VagonService {

	@Autowired
	private VagonRepository vagonRepository;

	public List<Vagon> findAll() {
		return vagonRepository.findAll();
	}

	public Optional<Vagon> findById(Integer id) {
		return vagonRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Vagon save(Vagon entity) {
		return vagonRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Vagon entity) {
		vagonRepository.delete(entity);
	}

}
	
