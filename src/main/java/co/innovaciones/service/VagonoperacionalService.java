package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Vagonoperacional;
import co.innovaciones.repository.VagonoperacionalRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VagonoperacionalService {

	@Autowired
	private VagonoperacionalRepository vagonoperacionalRepository;

	public List<Vagonoperacional> findAll() {
		return vagonoperacionalRepository.findAll();
	}

	public Optional<Vagonoperacional> findById(Integer id) {
		return vagonoperacionalRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Vagonoperacional save(Vagonoperacional entity) {
		return vagonoperacionalRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Vagonoperacional entity) {
		vagonoperacionalRepository.delete(entity);
	}

}
	
