package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Gamin;
import co.innovaciones.repository.GaminRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GaminService {

	@Autowired
	private GaminRepository gaminRepository;

	public List<Gamin> findAll() {
		return gaminRepository.findAll();
	}

	public Optional<Gamin> findById(Integer id) {
		return gaminRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Gamin save(Gamin entity) {
		return gaminRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Gamin entity) {
		gaminRepository.delete(entity);
	}

}
	
