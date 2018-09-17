package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Caniles;
import co.innovaciones.repository.CanilesRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CanilesService {

	@Autowired
	private CanilesRepository canilesRepository;

	public List<Caniles> findAll() {
		return canilesRepository.findAll();
	}

	public Optional<Caniles> findById(Integer id) {
		return canilesRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Caniles save(Caniles entity) {
		return canilesRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Caniles entity) {
		canilesRepository.delete(entity);
	}

}
	
